#include <iostream>
#define MAX 100000
using namespace std;

main(){
           //Declaración de variables
	double hipo, inver, difer,mitad,yo;
	
	cout<<"hipoteca de la casa: $"; //Dato de entrada
	cin>>hipo;
	cout<<"Inversion Negocio:   $"; //Dato de entrada
	cin>>inver;
	if (hipo>=MAX){  //Comparación con un dato fijo
		difer=inver-hipo;
		mitad=difer/2;// Operación para dividir la cantidad
		yo=hipo+mitad;
	}
	else{// en caso de que sea falso realiza el siguiente proceso
		mitad=inver/2;// solo realiza dos operaciones que tambien
		yo=mitad;/ se encuentran en caso de que sea verdadera la respuesta
	}
	//Imprime los mismos datos en ambos casos
	cout<<"Hipoteca de la casa:   $"<<hipo<<endl;
	cout<<"Inversión del Negocio: $"<<inver<<endl;
	cout<<"Socio: $"<<mitad<<endl;
	cout<<"Yo:    $"<<yo<<endl;
} // Fin del programa
