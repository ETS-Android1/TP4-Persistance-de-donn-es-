# Compte Rendu de TP4 : Persistance de données

La persistance désigne l'ensemble des techniques qui permettent de stocker des données sur le mobile. Grâce à la persistance, les données peuvent rester stockées tant que l'application est installée sur le téléphone.

**Android offre plusieurs méthodes pour stocker les données d’une application :**
- Préférences partagées
- Bases de données(SQLite)
- Fichiers (création et sauvegarde)

> Dans ce TP on va aborder la méthode de système des fichiers pour persister les données qu'ils sont ici les étudiants, alors notre application va : 
> 
1. RécuperéesRécupérer la liste des étudiants(déserialisés) persistée dans le fichier **"etudiants.dat"** 

![image](https://user-images.githubusercontent.com/81255636/159100446-8098ad8b-06f1-4c38-92d4-46df4730b85d.png)

2.  Ensuite Ajouter un étudiant à la liste(déserialisée) puis remplacer(serialiser) le contenu du fichier la liste **"etudiants.dat"** par la nouvelle liste qui contient le nouvél étudiant 

![159100540-2b4a1bd7-b88d-4bd3-9969-e01262476775](https://user-images.githubusercontent.com/81255636/159101422-8ec9dddf-1e50-4831-b439-eb4388d4b870.png)

3. Ce traitement est associé à l'interface de **nouvel étudiant**

![Screenshot_20220319-021051](https://user-images.githubusercontent.com/81255636/159101300-746f595d-19da-442c-87ea-1fc9bd7b1fa6.jpg)

4. Afficher par la suite la liste des étudinats déserialisés

![image](https://user-images.githubusercontent.com/81255636/159101925-b2400c96-12d5-4928-8a2b-d295f3901296.png)

5. Ce traitement est associé à l'interface de la **liste des étudiants**

![Screenshot_20220319-003320](https://user-images.githubusercontent.com/81255636/159102036-b7354edd-e8b8-497e-bd84-7f3f08f08ac9.jpg)
