package com.poker.game;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.poker.game.object.Card;
import com.poker.game.referee.Referee;

@SpringBootTest
class GameApplicationTests {

	@Test
	void ProbarMatch() {
		// Ejecuta todo el proceso con una linea de cartas otorgada como en el archivo de ejemplo
		
		String cards = "8C TS KC 9H 4S 8C TS KC 9H 4S";

		ArrayList<Card> manoJugador1 = new ArrayList<>();
		ArrayList<Card> manoJugador2 = new ArrayList<>();

		String[] splitMano = cards.split("\\s+");

		for (int i = 0; i < splitMano.length; i++) {
			String[] splitCarta = splitMano[i].split("");

			Card carta = new Card();
			carta.setRank(splitCarta[0]);
			carta.setSuit(splitCarta[1]);

			if (i < 5) {
				manoJugador1.add(carta);
			} else {
				manoJugador2.add(carta);
			}
		}

		Referee ref = new Referee();

		System.out.println(ref.classifyHand(manoJugador1));

		System.out.println(ref.classifyHand(manoJugador2));

		System.out.println(ref.desempatar(manoJugador1, manoJugador2));

		assertNotNull(ref.desempatar(manoJugador1, manoJugador2));
	}

	@Test
	void ProbarCalificarMano() {
		// Retorna la calificacion de la mano del jugador de acuerdo a sus componentes

		String hand1 = "8C TS KC 9H 4S";

		ArrayList<Card> manoJugador1 = new ArrayList<>();

		String[] splitMano = hand1.split("\\s+");

		for (int i = 0; i < splitMano.length; i++) {
			String[] splitCarta = splitMano[i].split("");

			Card carta = new Card();
			carta.setRank(splitCarta[0]);
			carta.setSuit(splitCarta[1]);

			manoJugador1.add(carta);
		}

		Referee ref = new Referee();

		System.out.println(ref.classifyHand(manoJugador1));

		assertNotNull(ref.classifyHand(manoJugador1));
	}

	@Test
	void ProbarDesempate() {
		// Retorna 1 si el jugador 1 gana, 2 si gana el segundo jugador, 3 si en verdad
		// es un empate

		String hand1 = "8C TS KC 9H 4S";
		String hand2 = "8C TS KC 9H 4S";

		ArrayList<Card> manoJugador1 = new ArrayList<>();

		ArrayList<Card> manoJugador2 = new ArrayList<>();

		String[] splitMano1 = hand1.split("\\s+");

		String[] splitMano2 = hand2.split("\\s+");

		for (int i = 0; i < splitMano1.length; i++) {
			String[] splitCarta = splitMano1[i].split("");

			Card carta = new Card();
			carta.setRank(splitCarta[0]);
			carta.setSuit(splitCarta[1]);

			manoJugador1.add(carta);
		}

		for (int i = 0; i < splitMano2.length; i++) {
			String[] splitCarta = splitMano2[i].split("");

			Card carta = new Card();
			carta.setRank(splitCarta[0]);
			carta.setSuit(splitCarta[1]);

			manoJugador2.add(carta);
		}

		Referee ref = new Referee();

		System.out.println(ref.classifyHand(manoJugador1));

		System.out.println(ref.classifyHand(manoJugador2));

		System.out.println(ref.desempatar(manoJugador1, manoJugador2));

		assertNotNull(ref.desempatar(manoJugador1, manoJugador2));
	}

}
