import java.util.ArrayList;
import java.util.List;

public class GetNavPageList {
    public List<Integer> getNavPageList(int currentPage, int pagesOfResults, int totalPagesOfResults) {

        validateInput(currentPage, pagesOfResults, totalPagesOfResults);

        var pages = new ArrayList<Integer>();
        var startingPage = getStartingPage(currentPage, pagesOfResults);
        var numberOfPagesToDisplay = pagesOfResults + startingPage;

        for (int i = startingPage; i < numberOfPagesToDisplay; i++) {
            pages.add(i);
        }
        return pages;
    }

    private int getStartingPage(int currentPage, int pagesOfResults) {
        if (currentPage < (pagesOfResults / 2) + 2) {
            return 1;
        } else {
            return currentPage - pagesOfResults / 2;
        }
    }

    private void validateInput(int currentPage, int pagesOfResults, int totalPagesOfResults) {
        if (currentPage < 0) {
            throw new IllegalArgumentException("Current Page must be greater than zero.");
        }
        if (currentPage > totalPagesOfResults) {
            throw new IllegalArgumentException("Current Page cannot be greater than Total Number of Pages.");
        }
        if (pagesOfResults <= 0) {
            throw new IllegalArgumentException("Pages of Results must be greater than zero.");
        }
    }
}
