#include "server.h"

// WSA Sockets de Windows
int wsaCreate() {
    num = WSAStartup(MAKEWORD(2,2), &WsaData);
    if (num != 0){
        printf("Error: WSAStartup() failed\n");
        return 1;
    }
    return num;
}

// Crear server socket
int createServerSocket() {
    serverSocket = socket(AF_INET, SOCK_STREAM, 0);
    if (serverSocket == INVALID_SOCKET) {
        printf("Error Server Socket\n");
        WSACleanup();
        return 1;
    }
    return serverSocket;
}

// Crear direcciones de sockets
int addressCreate() {
    memset(&server1, 0, sizeof(server1));
    server1.sin_family = AF_INET;
    server1.sin_addr.s_addr = htons(INADDR_ANY);
    server1.sin_port = htons(PORT_PORT);
    return 0;
}

// Vincular server socket
int bindServerSocket() {
    num = bind(serverSocket, (struct sockaddr *)&server1, sizeof(server1));
    if (num < 0) {
        printf("Error Bind\n");
        WSACleanup();
        return 1;
    }
    return num;
}

// Escuchar sockets
int listenServerSocket() {
    num = listen(serverSocket, 10);
    if (num < 0) {
        printf("Error Listening\n");
        WSACleanup();
        return 1;
    }
    return num;
}

// Aceptar sockets (en modo de threads)
void *acceptServerSocket(void *args) {
    socklen_t clilen = sizeof(client1);
    while(serverStatus) {
        clients[iClients] = accept(serverSocket, (struct sockaddr *)&client1, &clilen);

        pthread_create(&clientsThreadID[iClients], NULL, readClient, NULL);
        //pthread_join(clientsThreadID[iClients], NULL);

        printf("> Cliente: %d conectado <\n", iClients);

        iClients++;
    }
}

void notifyClients(char message[], int excludeClient) {
    char messageT[1024];
    char clientNum[10];
    
    memset(clientNum, 0, sizeof(clientNum));
    sprintf(clientNum, "%d", excludeClient);

    memset(messageT, 0, sizeof(messageT));
    strcat(messageT, "> Cliente ");
    strcat(messageT, clientNum);
    strcat(messageT, ": ");
    strcat(messageT, message);

    for (int i = 0; i < iClients; i++) {
        if (i != excludeClient) {
            sendMessage(messageT, i);
        }
    }
}

// Leer sockets (en modo de threads)
void *readClient(void *args) {
    int actualClient = iClients;
    
    char welcomeMessage[] = "> Hola, cliente X <";
    welcomeMessage[16] = actualClient + '0';
    sendMessage(welcomeMessage, actualClient);

    char buffer[1024];
    char info[1024];
    char *bufferPtr = buffer;
    char *infoPtr = info;
    int error;

    memset(buffer, 0, 1024);
    memset(info, 0, 1024);

    while (serverStatus) {
        error = recv(clients[actualClient], buffer, sizeof(buffer), 0); 
        if (error != -1) {
            if (buffer[0] != '!') {
                strcat(infoPtr, bufferPtr);
                memset(buffer, 0, error);
            } else {
                printf("Cliente %d: %s\n", actualClient, info);
                
                notifyClients(info, actualClient);  
                memset(buffer, 0, error);
                memset(info, 0, 1024);

                
            }
            
        }
    }
}

// Enviar mensaje a un socket en especifico
void sendMessage(char message[], int client) {
    int error = send(clients[client], message, strlen(message), 0);
}

// Funcion para inicializar serversocket, aceptar clientes y escucharlos.
int startServer() {
    wsaCreate();
    createServerSocket();
    addressCreate();
    bindServerSocket();
    listenServerSocket();

    serverStatus = true;

    pthread_create(&tAcpt, NULL, acceptServerSocket, NULL);
                
    // memset(&lastMessage, 0, sizeof(lastMessage));
    printf("Server started\n");
    while(1){};
    return 0;
}


int main() {
    startServer();
    return 0;
}