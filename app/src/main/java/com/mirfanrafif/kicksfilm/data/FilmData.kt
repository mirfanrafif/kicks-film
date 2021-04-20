package com.mirfanrafif.kicksfilm.data

object FilmData {
    private val movies = arrayListOf(
        Movie("Godzilla vs. Kong", 2021,
            "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
        83, "Adam Wingard", "Action, Science Fiction", "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg"),
        Movie("Zack Snyder's Justice League", 2021,
            "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
            85, "Zack Snyder", "Action, Adventure, Fantasy, Science Fiction", "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg"),
        Movie("Mortal Kombat", 2021,
            "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
            75, "Simon McQuoid", "Fantasy, Action, Adventure", "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/8yhtzsbBExY8mUct2GOk4LDDuGH.jpg"),
        Movie("Raya and the Last Dragon", 2021,
            "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
            83, "Don Hall, Carlos López Estrada", "Animation, Adventure, Fantasy, Family, Action", "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg"),
        Movie("Tom & Jerry", 2021,
            "Tom the cat and Jerry the mouse get kicked out of their home and relocate to a fancy New York hotel, where a scrappy employee named Kayla will lose her job if she can’t evict Jerry before a high-class wedding at the hotel. Her solution? Hiring Tom to get rid of the pesky mouse.",
            73, "Tim Story", "Comedy, Family, Animation", "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6KErczPBROQty7QoIsaa6wJYXZi.jpg"),
        Movie("The Croods: A New Age", 2021,
            "Searching for a safer habitat, the prehistoric Crood family discovers an idyllic, walled-in paradise that meets all of its needs. Unfortunately, they must also learn to live with the Bettermans -- a family that's a couple of steps above the Croods on the evolutionary ladder. As tensions between the new neighbors start to rise, a new threat soon propels both clans on an epic adventure that forces them to embrace their differences, draw strength from one another, and survive together.",
            75, "Joel Crawford", "Family, Fantasy, Animation, Comedy", "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/tbVZ3Sq88dZaCANlUcewQuHQOaE.jpg"),
        Movie("Joker", 2019,
        "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",
        82, "Todd Phillips", "Crime, Thriller, Drama", "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg"
        ),
        Movie("Demon Slayer – Kimetsu no Yaiba – The Movie: Mugen Train", 2020,
        "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!",
        80, "Haruo Sotozaki", "Animation, Action, Adventure, Fantasy, Drama", "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qfLpiXGV93x8EnZIjmuyO6qXBMx.jpg"
        ),
        Movie("Jumanji: The Next Level", 2019,
            "As the gang return to Jumanji to rescue one of their own, they discover that nothing is as they expect. The players will have to brave parts unknown and unexplored in order to escape the world’s most dangerous game.",
            70, "Jake Kasdan", "Adventure, Comedy, Fantasy", "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/jyw8VKYEiM1UDzPB7NsisUgBeJ8.jpg"
        ),
        Movie("Scooby-Doo! The Sword and the Scoob", 2021,
        "An evil sorceress transports the gang back to the age of chivalrous knights, spell-casting wizards, and fire-breathing dragons.",
        78, "Maxwell Atoms", "Animation, Comedy, Family, Mystery, Adventure", "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/sCoG0ibohbPrnyomtzegSuBL40L.jpg")
    )

    private val tvSeries = arrayListOf(
        Movie("The Falcon and the Winter Soldier", 2021,
            "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
            79, "Malcolm Spellman", "Sci-Fi & Fantasy, Action & Adventure, Drama, War & Politics", "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6kbAMLteGO8yyewYau6bJ683sw7.jpg"),
        Movie("The Flash", 2014,
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            77, "Greg Berlanti", "Drama, Sci-Fi & Fantasy", "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg"),
        Movie("The Walking Dead", 2010,
            "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
            81, "Frank Darabont", "Action & Adventure, Drama, Sci-Fi & Fantasy", "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg"),
        Movie("Superman & Lois", 2021,
            "After years of facing megalomaniacal supervillains, monsters wreaking havoc on Metropolis, and alien invaders intent on wiping out the human race, The Man of Steel aka Clark Kent and Lois Lane come face to face with one of their greatest challenges ever: dealing with all the stress, pressures and complexities that come with being working parents in today's society.",
            81, "Frank Darabont", "Action & Adventure, Drama, Sci-Fi & Fantasy", "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6SJppowm7cdQgLkvoTlnTUSbjr9.jpg"),
        Movie("Game of Thrones", 2011,
        "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
        84, "David Benioff", "Sci-Fi & Fantasy, Drama, Action & Adventure", "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg"
        ),
        Movie("Naruto", 2002,
        "In another world, ninja are the ultimate power, and in the Village Hidden in the Leaves live the stealthiest ninja in the land. Twelve years earlier, the fearsome Nine-Tailed Fox terrorized the village and claimed many lives before it was subdued and its spirit sealed within the body of a baby boy. That boy, Naruto Uzumaki, has grown up to become a ninja-in-training who's more interested in pranks than in studying ninjutsu.. but Naruto is determined to become the greatest ninja ever!",
        84, "(Tidak tahu)", "Animation, Action & Adventure, Sci-Fi & Fantasy", "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vauCEnR7CiyBDzRCeElKkCaXIYu.jpg"
        ),
        Movie("Money Heist", 2017,
        "To carry out the biggest heist in history, a mysterious man called The Professor recruits a band of eight robbers who have a single characteristic: none of them has anything to lose. Five months of seclusion - memorizing every step, every detail, every probability - culminate in eleven days locked up in the National Coinage and Stamp Factory of Spain, surrounded by police forces and with dozens of hostages in their power, to find out whether their suicide wager will lead to everything or nothing.",
        83, "Álex Pina", "Crime, Drama", "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/MoEKaPFHABtA1xKoOteirGaHl1.jpg"),
        Movie("DOTA: Dragon's Blood", 2021,
        "After encounters with a dragon and a princess on her own mission, a Dragon Knight becomes embroiled in events larger than he could have ever imagined.",
        82, "Ashley Edward Miller", "Action & Adventure, Animation, Sci-Fi & Fantasy", "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/s1wP1YeQS9fgSHiXZ3yJb2ufB2D.jpg")
    )

    fun getMovies(): List<Movie> = movies

    fun getTVShows(): List<Movie> = tvSeries
}