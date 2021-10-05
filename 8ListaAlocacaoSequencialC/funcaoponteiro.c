#include <string.h>
#include <stdio.h>

void Modificar(char *teste)
{
  strcat(teste, "Cruzeiro Esporte Clube");
}

int main(int argc, char const *argv[])
{

  char a[8] = "Cruzeiro";
  char *p;

  p = &a;

  char *v;

  v = &a;

  printf("%s\n", p);
  printf("%d\n", p);

  printf("%s\n", v);
  printf("%d\n", v);

  /*

  char teste3[20];
  Modificar(teste3);
  printf("%s\n", teste3);
  
  int x = 10;
  int *p;

  p = x;

  printf("%d\n", p);

  p = x + 1;

  printf("%d\n", p);

  char testeee[3] = "oie";
  char *v;
  char opa[3];

  v = &testeee;

  printf("%s\n", v);
  printf("%d\n", *v);

  
  */

  return 0;
}
