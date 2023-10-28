import java.util.List;

public class Account {
    private Information information;
    private List<Character> characters;
    private int gamesPlayed;

    public Account(Information information, List<Character> characters, int gamesPlayed) {
        this.information = information;
        this.characters = characters;
        this.gamesPlayed = gamesPlayed;
    }

    public static class Information {
        private Credentials credentials;
        private List<String> games;
        private String name, country;

        private Information(Builder builder) throws InvalidCommandException {
            if (builder.credentials == null || builder.name == null)
                throw new InvalidCommandException();

            credentials = builder.credentials;
            games = builder.games;
            name = builder.name;
            country = builder.country;
        }

        public static class Builder {
            private Credentials credentials;
            private List<String> games;
            private String name, country;

            public Builder setCredentials(Credentials credentials) {
                this.credentials = credentials;
                return this;
            }

            public Builder setGames(List<String> games) {
                this.games = games;
                return this;
            }

            public Builder setName(String name) {
                this.name = name;
                return this;
            }

            public Builder setCountry(String country) {
                this.country = country;
                return this;
            }

            public Information build() throws InvalidCommandException {
                return new Information(this);
            }
        }
    }
}
