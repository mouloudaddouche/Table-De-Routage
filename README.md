# Table De Routage
Conception d'une application en 2 versions : Console + Graphique, qui permet de trouver pour un noeud choisi, le noeud voisin qui 
a le plus court chemin pour lui acheminer les trames.

## À propos du projet :

le projet est composé de deux versions programmés en java, une qui nous offre un affichage de 100 noeuds sur la console avec
une interaction avec l’utilisateur grâce au clavier, une deuxième avec un affichage graphique de 20 noeuds (4 backbone, 6 de type 2,
10 de type 3) avec une interaction grâce à la souris.
Le coté algorithmique en soi est le même, la différence réside dans le fait que dans la première version l’affichage des noeuds
et des changements (le plus court chemin) se font sur la console par le biais de System.out.println(), dans l'autre version 
l’affichage est graphique grâce a JFrame qui est propre à java et la bibliothèque JGraphx.

### Prérequis
Avoir des connaissances en théorie des graphes.
Vous devez installer IDE Eclipse, Java Development Kit.

```
Lien :
Eclipse : https://www.eclipse.org/downloads/packages/release/mars/r/eclipse-ide-java-developers
JDK : https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html

```

## Langage utilisé :

- [Java](https://fr.wikipedia.org/wiki/Java_(langage)) - Langage de programmation de l'application.

## Utilisation
il suffit d'importer le dossier THG_Console ou THG_Graphique (ça depend la version voulu) dans Eclipseet lancer le fichier Main.java
