# Bataille
Projet JAVA - Bataille

## Description
Ce projet est un jeu de cartes simple basé sur le jeu de la Bataille. Deux joueurs s'affrontent pour gagner des cartes en jouant des cartes à tour de rôle. Le joueur avec la carte la plus haute remporte la manche, et en cas d'égalité, une bataille a lieu pour déterminer le gagnant.

## Structure du projet
Le projet est structuré en 3 classes principales :
- **`Carte`** : Représente une carte avec une couleur et une valeur.
- **`Joueur`** : Représente un joueur du jeu, avec un paquet de cartes et un score.
- **`Bataille`** : La classe principale qui exécute le jeu et gère la logique de jeu.

## Installation
1. Clonez le dépôt sur votre machine locale.
2. Compilez le projet
3. Exécutez le jeu de carte

## Point de blocage
J'ai rencontré quelques difficultés pour gérer l'ajout des cartes jouées dans un nouveau paquet et les réutiliser une fois les piles des joueurs épuisées. Par manque de temps, j'ai donc décidé de simplifier cette fonctionnalité en comptabilisant uniquement les scores à la fin d'un seul paquet de carte.
