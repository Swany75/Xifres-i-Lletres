# Xifres i Lletres
Joc de Xifres i Lletres fet amb Java com a projecte final de l'assignatura Programació I de la Enginyeria Informàtica. 

- 📄 [Memòria del projecte](/Memòria%20-%20Projecte%20Programació%20I_%20Xifres%20i%20Lletres.pdf)
- 📘 [Enunciat en català](Enunciats/enunciat_practica_cat.pdf)
- 📕 [Enunciat en castellà](Enunciats/enunciat_practica_cast.pdf)

<p align="center">
  <img width="320" height="392"
       src="https://github.com/user-attachments/assets/64868e52-3466-4f25-96db-e73cc66ca15e"
       alt="image">
</p>

## Descripció del joc

### Rondes de lletres
- Es generen **10 lletres** aleatòries a partir d’una "bossa de lletres".
- El jugador introdueix una paraula.
- La paraula és vàlida si:
  - Només utilitza les lletres disponibles, respectant la seva multiplicitat.
  - Existeix al diccionari proporcionat.
- La puntuació és igual a la longitud de la paraula.
- La CPU cerca la millor paraula possible dins el diccionari.

### Rondes de xifres
- Es generen **6 xifres** aleatòries a partir d’una bossa estàndard.
- Es genera un objectiu entre **100 i 999**.
- Es permeten les operacions: `+`, `-`, `*`, `/` (divisió exacta).
- Cada xifra només pot usar-se una vegada.
- La CPU fa una recerca aleatòria amb un nombre limitat d’intents.
- La puntuació depèn de la diferència amb l’objectiu:
  - Diferència 0 → 25 punts
  - Diferència 1 → 18 punts
  - Diferència 2 → 15 punts
  - Diferència 3 → 12 punts
  - Diferència 4 → 10 punts
  - Diferència 5 → 8 punts
  - Diferència entre 6 i 10 → 5 punts
  - Diferència entre 11 i 15 → 0 punts


```
 __   ___  __                 _   _     _      _                 
 \ \ / (_)/ _|               (_) | |   | |    | |                
  \ V / _| |_ _ __ ___  ___   _  | |   | | ___| |_ _ __ ___  ___ 
  /   \| |  _| '__/ _ \/ __| | | | |   | |/ _ \ __| '__/ _ \/ __|
 / /^\ \ | | | | |  __/\__ \ | | | |___| |  __/ |_| | |  __/\__ \
 \/   \/_|_| |_|  \___||___/ |_| \_____/_|\___|\__|_|  \___||___/
════════════════════════════════════════════════════════════════════════════════════════

[*] Programa fet per: Juan Dalmau

[+] Executant: Xifres i Lletres
	- 'Q/q' per sortir (quit)
	- 'R/r' per veurer el registres
	- 'C/c' per continuar (continue)

[+] Introdueix una opció valida: 
```

## Requisits tècnics

- Java
- Projecte **NetBeans Java Ant**
- Execució per consola
- Interacció per teclat mitjançant la classe `LT`

## Restriccions respectades

- No s’utilitzen estructures dinàmiques (`ArrayList`, `LinkedList`, etc.).
- No s’utilitzen mètodes prohibits de `String` ni `Arrays`.
- No s’utilitzen tècniques avançades no vistes a classe (recursivitat, backtracking, regex…).
- No es carreguen fitxers grans completament en memòria.
- Disseny orientat a objectes segons els criteris de l’assignatura.

## Execució

1. Obrir el projecte amb **NetBeans**.
2. Executar el projecte Java Ant.
3. Interactuar amb el programa mitjançant el menú principal per consola.