package code._4_student_effort._2_movie_database;

public class Database {
    public static void main(String[] args) {
        Premiu oscar1990 = new Premiu("oscar", 1990);
        Premiu oscar2000 = new Premiu("oscar", 2000);
        Premiu oscar2010 = new Premiu("oscar", 2010);
        Premiu oscar2018 = new Premiu("oscar", 2018);

        Actor actorOscar1990 = new Actor("actor cu 2 oscaruri", 35, new Premiu[]{oscar1990, oscar2000});
        Actor actorOscar2010 = new Actor("actor cu oscar din 2000", 55, new Premiu[]{oscar2010});
        Actor actorOscar2018 = new Actor("actor cu oscar din 2018", 23, new Premiu[]{oscar2018});
        Actor actorFaraPremii01 = new Actor("actor fara oscar 01", 33, new Premiu[]{});
        Actor actorFaraPremii02 = new Actor("actor fara oscar 02", 60, new Premiu[]{});
        Actor actorFaraPremii03 = new Actor("actor fara oscar 03", 20, new Premiu[]{});

        Film film1 = new Film("film cu actori de oscar", 1990, new Actor[]{actorOscar1990, actorFaraPremii01});
        Film film2 = new Film("film cu actori fara premii2", 2010, new Actor[]{actorFaraPremii01, actorFaraPremii02, actorFaraPremii03});
        Film film3 = new Film("film cu actori fara premii3", 2010, new Actor[]{actorFaraPremii01, actorFaraPremii02, actorFaraPremii03});
        Film film4 = new Film("film cu actori de oscar", 2018, new Actor[]{actorOscar2010, actorOscar2018, actorFaraPremii02});
        Film film5 = new Film("film cu actori fara premii5", 2018, new Actor[]{actorFaraPremii02, actorFaraPremii03});

        Studio studio1 = new Studio("MGM", new Film[]{film1, film2});
        Studio studio2 = new Studio("Disney", new Film[]{film3, film4, film5});
        Studio[] studioDatabase = new Studio[]{studio1, studio2};

        System.out.println("Get the studio names that have published more than 2 movies: ");
        for (Studio studio : studioDatabase) {
            if (studio.getFilme().length > 2) System.out.println(studio.getNume());
        }

        System.out.println("Get the studio names in which plays the actor with name \"actor cu 2 oscaruri\": ");
        for (Studio studio : studioDatabase) {
            for (Film film : studio.getFilme()) {
                for (Actor actor : film.getActori()) {
                    if (actor.getNume().equals("actor cu 2 oscaruri")) {
                        System.out.println(studio.getNume());
                        break;
                    }
                }
            }
        }

        System.out.println("Get movies names in which plays at least an actor with age above 50: ");
        for(Studio studio : studioDatabase) {
            for(Film film : studio.getFilme()) {
                for(Actor actor : film.getActori()) {
                    if(actor.getVarsta() > 50) {
                        System.out.println(film.getNume());
                        break;
                    }
                }
            }
        }

    }
}
