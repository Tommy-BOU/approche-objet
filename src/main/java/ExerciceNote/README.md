# Spécifications fonctionnelles
Nous avons besoin de réaliser une application pour gérer un port.  
Le port a un parking Voiture et un parking Moto.  
Il a également un bassin qui permet d'amarer des bateaux.  
L'application doit permettre de gérer les parkings et le bassin

# Spécifications techniques Lot 1 (12 points max)
1. Créer une classe abstraite *ExerciceNote.Vehicules.Vehicule* avec :
	* des propriétés *marque*, *modele* et *numImmat*
	* un constructor qui définit les propriétés
	* les getter qui vont bien
	* Une méthode qui afficher l'objet sous la forme : "N° : *{numImmat}*, Modéle : *{marque}* *{modele}*", 

2. Créer 2 classes abstraites qui héritent de *ExerciceNote.Vehicules.Vehicule* :
	* *ExerciceNote.Vehicules.Routier*
	* *ExerciceNote.Vehicules.Maritime* 

3. Créer 1 interface *ExerciceNote.Vehicules.AMoteur* avec une méthode *remplirReservoir()*

4. Créer 4 classes :
	* *ExerciceNote.Vehicules.Voiture* qui hérite de *ExerciceNote.Vehicules.Routier* et implémente *ExerciceNote.Vehicules.AMoteur* 
	* *ExerciceNote.Vehicules.Moto* qui hérite de *ExerciceNote.Vehicules.Routier* et implémente *ExerciceNote.Vehicules.AMoteur*
	* *ExerciceNote.Vehicules.Bateau* qui hérite de *ExerciceNote.Vehicules.Maritime* et implémente *ExerciceNote.Vehicules.AMoteur*
	* *ExerciceNote.Vehicules.Voilier* qui hérite de *ExerciceNote.Vehicules.Maritime*
	* Pour ces 4 classes, la méthode qui affiche l'objet affichera en plus le type de véhicule. Exemple : "Voiture N° : *{numImmat}*, Modéle : *{marque}* *{modele}*"

5. Créer 1 classe *ExerciceNote.Port* avec :
	* 1 tableau qui contiendra des objets de type *ExerciceNote.Vehicules.Voiture*
	* 1 tableau qui contiendra des objets de type *ExerciceNote.Vehicules.Moto*
	* 1 tableau qui contiendra des objets de type *ExerciceNote.Vehicules.Maritime* 
	* Une méthode *garer()* qui permet de garer un véhicule routier (ajout du véhicule dans le tableau associé)
	* Une méthode *amarer()* qui permet d'amarer un véhicule maritime (ajout du véhicule dans le tableau associé)
	* Une méthode *sortir()* qui permet de sortir un véhicule routier ou maritime (suppression du véhicule du bon tableau)
	* Une méthode qui affiche l'état du port (le nombre de voiture, de moto, de bateau ou voilier dans le port)

**Factoriser au maximum le code pour écrire le moins de code en double possible.**  

**Le code doit permettre d'éxécuter le fichier Main.java fourni.**  


# Spécifications techniques Lot 2 (8 points max)
1. Définir un maximum de 10 de places pour les voitures et 5 places pour les motos dans le parking  
Si plus de place, la méthode garer() génére une exception.

2. Définir un maximum de 20 de places pour les bateau et voilier dans le port  
Si plus de place, la méthode amarer() génére une exception.

3. Définir un réservoir d'essence pour le port de 500 litres.
	* Ajouter une méthode *getReservoir()* dans l'interface *AMoteur* pour définir la taille du réservoir sur un véhicule à moteur.
	* Ajouter le nombre de litre restant dans le réservoir du port sur la méthode qui affiche l'objet
	* Modifier le constructor des classes qui implémentent l'interface pour pouvoir préciser la taille du réservoir avec par défaut :
		* pour les voitures le réservoir sera de 50 litres
		* pour les motos le réservoir sera de 20 litres
		* pour les bateaux de le réservoir sera de 200 litres
	* Si la taille du réservoir passé sur le constructor est <= 0, on génére une exception
	* Ajouter une méthode *obtenirCarburant()* sur la classe *Port* pour prendre une certaine quantité de carburant dans son réservoir (le plein d'un réservoir d'un véhicule à moteur).  
	Si la réserve n'a plus assez de carburant, la méthode génére une exception.
	* Modifier les méthodes *remplirReservoir()* pour qu'elles générent une exception si le remplissage ne peut aboutir
4. Ajouter une méthode *remplirReservoir()* sur le port pour remplir de nouveau le réservoir du port
	* Modifier le constructor du port pour que l'on puisse lui préciser :
		* le nombre de places de parking Voiture (par défaut 10)
		* le nombre de places de parking Moto (par défaut 5)
		* le nombre de places dans le bassin pour les bateaux et les voiliers (par défaut 20)
		* le nombre de litre max du réservoir (par défaut 500)
	* Si la taille des places sur le constructor est < 0, on génére une exception
	* Si la taille du réservoir passé sur le constructor est <= 0, on génére une exception
	* Ajouter une méthode *getReservoirMax()* sur le port pour retourner la taille maximum du réservoir
	* Ajouter une méthode *getReservoir()* sur le port pour retourner le nombre de litre restant du réservoir

**Factoriser au maximum le code pour écrire le moins de code en double possible.**  

**Le code doit permettre d'éxécuter le fichier Main2.java fourni.**  
