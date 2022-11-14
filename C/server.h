#ifndef server_h
#define server_h

#include <winsock2.h>
#include <windows.h>
#include <ws2tcpip.h>
#include <stdlib.h>
#include <stdio.h>
#include <pthread.h>
#include <string.h>
#include <stdbool.h>

#define PORT_PORT 1337

// Variables inicializacion de servidor
WSADATA WsaData;
int num;
int serverSocket;
struct sockaddr_in server1;
struct sockaddr_in client1;
bool serverStatus = false;
int iClients = 0;
pthread_t tAcpt;

// Variables de manipulacion de clientes
int clients[10];
pthread_t clientsThreadID[10];


// Funciones de inicializacion de servidor
int wsaCreate();
int createServerSocket();
int addressCreate();
int bindServerSocket();
int listenServerSocket();
void *acceptServerSocket(void *args);

// Funciones de manipulacion de mensajes
void *readClient(void *args);
void sendMessage(char message[], int client);
void notifyClients(char message[], int excludeClient);

#endif // server_h
