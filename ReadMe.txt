# THL – Calculatrice scientifique en MVàP

Ce dépôt contient notre projet de **calculatrice scientifique compilée vers MVàP** réalisé dans le cadre du module **THL** (Devoir Maison / DM17).

L’objectif est de prendre en entrée un mini-langage impératif (avec variables, fonctions, boucles, conditions, etc.), et de **générer du code MVàP** exécutable sur la machine virtuelle fournie dans le cadre du cours.

---

## 👥 Auteurs

- **Wassim DJEHA** – n° étudiant : 22208244  
- **Louheb KACED** – n° étudiant : 22111744  

---

## 📁 Contenu du projet

Les fichiers principaux sont :

- `Calculette.g4` : grammaire ANTLR de notre langage de calculatrice.
- `CalculetteLexer.java`, `CalculetteParser.java`, `CalculetteBaseListener.java`, `CalculetteListener.java`  
  Générés par ANTLR à partir de `Calculette.g4` (contenus dans le dépôt pour faciliter les tests).
- `TablesSymboles.java`, `TableSimple.java`, `VariableInfo.java`  
  Gestion des **tables de symboles**, des types et des adresses mémoire (variables globales, locales, paramètres).
- Dossier `.antlr/` : fichiers générés par ANTLR (intermédiaires, .interp, .tokens, etc.).
- `ReadMe.txt` : consignes de rendu et description succincte du projet fournies pour le DM.

---

## 🧩 Fonctionnalités implémentées

Nous avons couvert **toutes les parties du sujet**, de la section **A** à **M**, ainsi que les **améliorations** demandées.  
Ci-dessous un résumé des principaux points.

### A. Génération de code MVàP

- Grammaire ANTLR pour parser des **expressions mathématiques**.
- Prise en charge des opérations arithmétiques classiques : `+`, `-`, `*`, `/`, `%`.
- Respect des **priorités opératoires** (parenthèses, produits avant sommes, etc.).
- Génération des instructions MVàP correspondantes (ex : `PUSHI`, `MUL`, `ADD`, `FSUB`, etc.).

### B. Variables (globales, locales, typées)

- Gestion des **variables globales et locales**.
- Types supportés : `int`, `double`, `bool`.
- Déclaration et affectation possibles :
  - dans le **main**,
  - dans le **corps des fonctions**.
- Utilisation d’une table des symboles pour suivre :
  - le type de chaque variable,
  - son adresse (position dans la pile),
  - son scope (global / paramètre / local).

### C. Entrées / sorties

- Prise en charge des instructions d’E/S :
  - `readln` : lecture d’une valeur depuis l’entrée standard,
  - `println` : affichage d’une valeur.
- Génération du code MVàP adapté (lecture / affichage de valeurs typées).

### D. Expressions logiques

- Extension de la grammaire pour inclure les **opérateurs logiques et relationnels**.
- Support par exemple de :
  - opérateurs de comparaison : `<`, `>`, `<=`, `>=`, `==`, `<>`,
  - combinaisons avec booléens.
- Génération des instructions MVàP logiques / de comparaison adaptées pour `int` et `double`.

### E. Boucles et structures de contrôle

- Génération de code pour :
  - **boucle `while`**,
  - **boucle `for`**,
  - **instructions conditionnelles `if` / `if-else`**.
- Gestion des labels (étiquettes) pour les sauts conditionnels et inconditionnels dans le code MVàP.

### F. Fonctions (itératives et récursives)

- Définition et appel de **fonctions** :
  - avec ou sans **valeur de retour**,
  - avec ou sans **arguments**,
  - support des **fonctions récursives**.
- Gestion :
  - des paramètres,
  - des variables locales,
  - du type de retour pour générer le bon code de fin de fonction.

### G. Conversion de types

- Gestion des conversions nécessaires entre :
  - `int` ↔ `double`,
  - `bool` ↔ `int` (par exemple).
- Génération d’instructions adaptées pour garantir la **cohérence des opérations**.
- Permet de combiner des expressions mixtes tout en préservant la validité des calculs.

### H. Flottants et booléens

- Prise en charge complète :
  - des **flottants** (`double`) pour les opérations arithmétiques,
  - des **booléens** pour les conditions et expressions logiques.
- Utilisation d’opcodes spécifiques « flottants » pour les opérations sur `double`.

### O. Améliorations réalisées

En plus des exigences de base, nous avons :

- Étendu la calculatrice pour supporter **plusieurs types de données** (int, double, bool).
- Ajouté la possibilité :
  - d’effectuer des **opérations arithmétiques** et **des comparaisons** sur les flottants,
  - de manipuler proprement des **variables booléennes** dans les conditions,
  - d’enchaîner les **conversions de types** (int ⇄ double, bool ⇄ int) en toute transparence.

---

## 🛠️ Compilation et exécution (résumé)

L’environnement exact dépend de l’infrastructure fournie dans le TP/DM, mais l’idée générale est :

1. **Générer (si besoin) les fichiers ANTLR** à partir de `Calculette.g4` :
   - via ANTLR4 (ligne de commande ou plugin),
   - les fichiers générés (`CalculetteLexer.java`, `CalculetteParser.java`, etc.) sont déjà présents dans ce dépôt.

2. **Compiler les fichiers Java** :

   ```bash
   javac *.java
