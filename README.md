# PixelTracer  
## Migration d’un moteur de rendu ASCII de C vers Java

---

# Organisation du dépôt GitHub

Le projet est organisé en plusieurs dossiers et branches afin de séparer clairement :

- La version originale en C, avec l'ajout d'une documentation et des commentaires sur l'ensemble du projet.
- La version migrée en Java  
- La documentation du projet  

## Structure des dossiers 

pixel_tracer/  
│  
├── pixel_tracer_c/         -> Version originale en C  
├── pixel_tracer_java/      -> Version orientée objet en Java  
└── Doc/                    -> Rapport, documentation et ressources  

## Organisation des branches

- main  -> Version stable finale
- pixel_tracer_c  -> Code original et documentation de la version C
- pixel_tracer_java  -> Développement de la version Java
- Doc  -> Branche dédiée à la documentation excluant Doxygen (Contenant les Diagramme demandé)

Objectifs de cette organisation :

- Isoler les deux implémentations
- Permettre une comparaison claire C vs Java
- Maintenir une base propre pour la documentation
- Faciliter le versioning et la maintenance

# Projet initial

Le projet PixelTracer est un moteur de rendu ASCII permettant :

- La création de formes géométriques
- La gestion de calques (layers)
- Le remplissage de formes
- L’interprétation de commandes textuelles
- L’affichage d’un rendu dans le terminal

## Objectif principal

Migrer un projet structuré en C procédural vers une architecture orientée objet en Java, tout en :

- Conservant les fonctionnalités
- Améliorant la maintenabilité
- Modernisant l’architecture
- Appliquant les principes de programmation orientée objet

# Version C - Architecture procédurale

## Fichiers principaux

area.c / area.h  
shape.c / shape.h  
pixel.c / pixel.h  
layers.c / layers.h  
render.c / render.h  
pixel_tracer.c / pixel_tracer.h  
command.c / command.h  
list.c / list.h  
main.c  
makefile  

## Caractéristiques techniques

- Utilisation de struct
- Gestion manuelle de la mémoire (malloc, free)
- Listes chaînées personnalisées
- Fonctions globales
- Manipulation de pointeurs

## Organisation logique

- shape.* -> Gestion des formes
- area.* -> Zone de dessin
- pixel.* -> Gestion des pixels
- layers.* -> Gestion des calques
- render.* -> Affichage terminal
- command.* -> Parsing des commandes
- list.* -> Implémentation liste chaînée

# Version Java - Architecture orientée objet

## Fichiers principaux

App.java  
PixelTracer.java  
Area.java  
Layer.java  
Shape.java  
Pixel.java  
Point.java  
Line.java  
Rectangle.java  
Square.java  
Circle.java  
Polygon.java  
Curve.java  

## Principes utilisés

- Encapsulation
- Héritage
- Polymorphisme
- Collections(librairies) Java (ArrayList)

# Correspondance C -> Java

| C             | Java                                                      | Rôle                                  |
| ------------- | --------------------------------------------------------- | ------------------------------------- |
| main.c        | App.java                                                  | Point d’entrée                        |
| pixel.c       | Pixel.java                                                | Représentation d’un pixel             |
| shape.c       | Shape.java (ainsi que toutes les sous classes des formes) | Classe abstraite                      |
| list.c        | ArrayList (Collections)                                   | Gestion dynamique                     |
| layers.c      | Layer.java                                                | Gestion des calques                   |
| area.c        | Area.java                                                 | Surface de rendu                      |
| render.c      | Dans toutes les sous classes des formes                   | Moteur de rendu                       |
| command.c     | PixelTracer.Java                                          | Gestion des commandes dans la console |
| pixeltracer.c | PixelTracer.Java                                          | Classe principale                     |
| id.c          | UUID (Collections)                                        | Gestion dynamique                     |

# Architecture orientée objet

## Classe héritant de Shape.java

Point.java
Line.java
Curve.java
Square.java
Rectangle.java
Circle.java
Polygon.java

## Interface:
### Fillable
Fillable permet de pouvoir remplir l'air d'une forme d'un caractère choisit
Classes implémentant cette interface:
Square.java
Rectangle.java
Circle.java
Polygon.java

## Avantages

- Factorisation du code
- Extensibilité
- Maintenance facilitée
- Réduction des duplications
- Polymorphisme

# Gestion des Layers

Chaque Layer contient :

- Une liste de Shape
- Un état de visibilité
- Un ordre d’affichage

Le rendu final :

1. Parcours des layers visibles
2. Superposition des pixels
3. Résolution des conflits selon l’ordre des calques



# Fonctionnalitées - Manuel d’Utilisation

# Syntaxe Générale des Commandes

# Commandes de Contrôle

## help

Affiche la liste des commandes disponibles.

Utilisation :
~> help

Description :
Affiche toutes les catégories de commandes et leur syntaxe.
À utiliser dès que besoin

---

## plot

Affiche le rendu de l’area courante dans le terminal.
Utilisation :
~> plot

Description :
- Met à jour la carte des pixels
- Superpose les layers visibles
- Affiche le résultat dans la console

---
## clear

Efface l’écran.
Utilisation :
~> clear

Description :
Renvoie l’instruction de nettoyage du terminal.

---

## exit

Quitte le programme.
Utilisation :
~> exit

Description :
Arrête l’application.

---
# Commandes de Dessin

Toutes les formes sont ajoutées au layer actuellement sélectionné.

---
## point

Crée un point à une position donnée.
Utilisation :
~> point px py

Exemple :
~> point 10 5

Description :
Ajoute un pixel aux coordonnées (px, py).

---
## line

Dessine une ligne entre deux points.
Utilisation :
~> line x1 y1 x2 y2

Exemple :
~> line 5 5 20 10

Description :
Trace une ligne entre (x1, y1) et (x2, y2).

---
## square

Dessine un carré.
Utilisation :
~> square x y l

Exemple :
~> square 10 10 5

Description :
Dessine un carré :
- Coin supérieur gauche en (x, y)
- Longueur de côté l

---
## rectangle

Dessine un rectangle.
Utilisation :
~> rectangle x y w h

Exemple :
~> rectangle 5 5 10 4

Description :
Dessine un rectangle :
- Coin supérieur gauche en (x, y)
- Largeur w
- Hauteur h

---
## circle

Dessine un cercle.
Utilisation :
~> circle x y r

Exemple :
~> circle 40 20 8

Description :
Dessine un cercle :
- Centre en (x, y)
- Rayon r

---
## polygon

Dessine un polygone.

Utilisation :
~>polygon x1 y1 x2 y2 x3 y3 ...

Exemple :
polygon 10 10 20 10 15 20

Description :
- Minimum 3 points (6 valeurs)
- Nombre de paramètres pair
- Relie les points et ferme automatiquement la forme

---
## curve

Dessine une courbe de Bézier.
Utilisation :
~> curve x1 y1 x2 y2 x3 y3 ...

Exemple :
curve 10 10 20 30 40 10

Description :
- Minimum 3 points de contrôle
- Nombre de paramètres pair
- Trace une courbe de Bézier

---
# Commandes de Gestion

---

## list

Affiche les éléments existants.
Utilisation :
~> list areas  
~> list layers  
~> list shapes  

Description :

- list areas  -> Affiche toutes les areas
- list layers  -> Affiche les layers de l’area courante
- list shapes  -> Affiche les formes du layer courant et ses statistiques

**PERMET DE RÉCUPÉRER LES IDS DES FORMES**

---
## new

Crée un nouvel élément.
Utilisation :  
~> new area  
~> new layer  

Description :

- new area  -> Crée et sélectionne une nouvelle zone de dessin
- new layer  -> Crée un nouveau layer dans l’area courante

---
## select

Sélectionne une area ou un layer via son identifiant (UUID).
Utilisation :  
~> select area UUID  
~> select layer UUID  

Exemple :
~> select area 123e4567-e89b-12d3-a456-426614174000

Description :  
Change l’élément actif.

Utiliser list areas ou list layers pour récupérer les identifiants.

---

## delete

Supprime un élément.
Utilisation :  
~> delete area UUID  
~> delete layer UUID  
~> delete shape UUID  

Description :  
Supprime l’élément correspondant.

Restrictions :
- Impossible de supprimer l’area courante
- Impossible de supprimer le layer courant

---

# Commandes de Configuration

---

## set char

Modifie les caractères d’affichage.
Utilisation :  
~> set char border X  
~> set char background .  

Description :

- border  -> Modifie le caractère de bordure des formes du layer courant
- background  -> Modifie le caractère vide de l’area

Exemple :  
set char border #  
set char background .  

---
## set layer

Modifie la visibilité d’un layer.
Utilisation :  
~> set layer visible UUID  
~> set layer unvisible UUID  

Description :  
- visible  -> Rend le layer visible
- unvisible  -> Masque le layer

---

# Commandes Bonus

---

## translate

Déplace une forme.
Utilisation :  
~> translate UUID dx dy

Exemple :  
~> translate 123e4567-e89b-12d3-a456-426614174000 5 -2

Description :
Déplace la forme :
- dx  -> déplacement horizontal
- dy  -> déplacement vertical

---

## fill

Remplit une forme avec un caractère.
Utilisation :  
~> fill UUID c

Exemple :  
~> fill 123e4567-e89b-12d3-a456-426614174000 *

Description :  
Remplit l’intérieur d’une forme avec le caractère spécifié.

Limitations :  
- Non supporté pour line
- Non supporté pour point
- Non supporté pour curve

Seules les formes implémentant l’interface Fillable peuvent être remplies.

---
# Messages d’Erreur

commande inconnue  
 -> La commande n’existe pas  

commande manquante  
 -> Commande vide  

erreur paramètres  
 -> Nombre ou type de paramètres incorrect  

L'objet référencé est en cours d'utilisation  
 -> Impossible de supprimer l’élément actif  

L'objet référencé n'est pas trouvable  
 -> Identifiant introuvable  

shape not found  
 -> La forme n’existe pas  

This shape cannot be filled  
 -> Remplissage non autorisé pour cette forme  

---

# Informations Importantes

- Chaque forme possède un identifiant unique (UUID).
- Utiliser list shapes pour récupérer un identifiant.
- Seuls les layers visibles sont affichés.
- Taille par défaut de l’area : 80 x 50.




# Différences majeures C vs Java

| Aspect       | C                           | Java            |
| ------------ | --------------------------- | --------------- |
| Paradigme    | Procédural                  | Objet           |
| Mémoire      | Manuelle                    | Automatique     |
| Sécurité     | Segmentation fault possible | Sécurisé        |
| Listes et id | Implémentation maison       | ArrayList, UUID |
| Héritage     | Simulation via struct       | Natif           |

Pour lancer le projet Java  :

    Sur Windows : 
    
        - Ouvrir un Invite de commande et se placer dans le dossier pixel_tracer_java/src
        - Vérifier que Java est installé avec la commande java -version (recommandé : Java 17+)
        - Exécuter la commande javac *.java pour compiler les classes .java en fichier .class
        - Lancer le programme en exécutant java App

    Sur Linux :

        - Ouvrir un terminal et se placer dans le dossier pixel_tracer_java/src
        - Vérifier que Java est installé avec la commande java -version (recommandé : Java 17+)
        - Exécuter la commande javac *.java pour compiler les classes .java en fichier .class
        - Lancer le programme en exécutant java App

Ou ouvrir le projet en entier dans VSCode



Pour lancer le projet C :

    Linux : 

        - Ouvrir un terminal et se placer dans le dossier pixel_tracer_c
        - Exécuter la commande make pour compiler le projet
        - Lancer le programme avec la commmande ./pixel_tracer

    Windows : 

        - Ouvrir un terminal et se placer dans le dossier pixel_tracer_c
        - Exécuter la commande mingw32-make pour compiler le projet
        - Lancer le programme en ouvrant le fichier pixel_tracer.exe
