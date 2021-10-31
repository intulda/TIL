package example.page24.refactor;

public class Rental {

    private Movie _movie;
    private int _dayRented;

    public Rental(Movie movie, int dayRented) {
        _movie = movie;
        _dayRented = dayRented;
    }

    public int getDaysRented() {
        return _dayRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    // 비디오 종류별 대여료 계산 기능을 빼내어 별도의 함수로 작성
    double getCharge() {
        return _movie.getCharge(_dayRented);
    }

    int getFrequentRenterPoints() {
        return _movie.getFrequentRenterPoints(_dayRented);
    }
}
