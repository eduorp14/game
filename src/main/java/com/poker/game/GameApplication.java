package com.poker.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.poker.game.object.Card;
import com.poker.game.referee.Referee;

@SpringBootApplication
public class GameApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(GameApplication.class, args);

		// Reading file
		Referee referee = new Referee();

		int cont1 = 0;
		int cont2 = 0;
		int cont3 = 0;

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("../game/src/main/resources/pokerdata.txt"));
			String line = reader.readLine();
			// Line by line
			while (line != null) {

				ArrayList<Card> manoJugador1 = new ArrayList<>();
				ArrayList<Card> manoJugador2 = new ArrayList<>();

				String[] splitMano = line.split("\\s+");

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

				// Compare hands and declare winner
				if (referee.match(manoJugador1, manoJugador2) == 1) {
					cont1++;
				} else if (referee.match(manoJugador1, manoJugador2) == 2) {
					cont2++;
				} else if (referee.match(manoJugador1, manoJugador2) == 3) {
					cont3++;
				} else {
					System.out.println("Error en datos");
				}

				// read next line
				line = reader.readLine();
			}
			reader.close();

			System.out.println("1: Victorias del jugador 1 " + cont1);
			System.out.println("2: Victorias del jugador 2 " + cont2);
			System.out.println("3: Empates " + cont3);
			System.out.println("4: ");
			System.out.println("----------Player1---------|----------Player2---------");

			double porc1 = ((double)cont1 * 100) / 1000;
			double porc2 = ((double)cont2 * 100) / 1000;

			System.out.println(porc1 + "% |" + porc2 + "%"); 

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
