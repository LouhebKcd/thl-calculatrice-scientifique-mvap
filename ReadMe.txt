README pour le rendu final du projet

Ce fichier présente nos réalisations dans le cadre du projet de calculatrice scientifique en MVàP :

Nous avons réussi à couvrir toutes les parties du TP, de la section A à la section M, en passant avec succès tous les benchmarks proposés. De plus, nous avons apporté quelques améliorations significatives. Ci-dessous, vous trouverez une brève description de ce que nous avons réalisé :

A- Génération de code MVàP :
    Nous avons créé une grammaire ANTLR pour générer du code MVàP à partir d'expressions mathématiques, prenant en charge les opérations de base avec respect des priorités opérationnelles.

B- Traitement des variables :
    Prise en charge des variables globales et locales de type int, double et bool avec gestion des déclarations et assignations dans le main comme dans le coeur des fonctions.

C- Traitement des entrées/sorties :
    Mise en place de la gestion des entrées et des sorties grace aux instruction readln et println pour permettre une interaction avec le programme.

D- Expressions logiques :
    Extension de la grammaire pour inclure les opérateurs logiques, permettant l'évaluation des conditions booléennes.

E- Boucle for , while et instructions if-else :
    Ajout de la génération du code pour la boucle for et while, gestion des instructions if-else pour pour améliorer notre calculatrice MVaP.

F- Fonctions :
    Mise en place des fonctions (itératives et récursives) avec ou sans valeur de retour, avec ou sans arguments, pour tous les types de variables qu'on a mis en place.

G- Conversion de types :
    Réalisation de la conversion entre les différents types de données pour assurer la cohérence des opérations (par exemple int vers double , bool vers int ...).

H- Manipulation des flottants et booléens :
    Extension de la prise en charge pour inclure les opérations arithmétiques et logiques avec les flottants et les booléens.

O- Améliorations réalisées : 
    En ce qui concerne les améliorations proposées, nous avons réalisé celle de supporter plusieurs types. Nous avons étendu les fonctionnalités de notre calculatrice pour prendre en charge plusieurs types de données, y compris les flottants et les booléens. Grâce à l'intégration d'opcodes spécifiques dans notre grammaire MVÀP, nous pouvons désormais effectuer des opérations arithmétiques et des comparaisons sur les flottants avec précision. De plus, la gestion des variables booléennes permet une manipulation simplifiée des conditions. Les conversions entre différents types sont également supportées.

