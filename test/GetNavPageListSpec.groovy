import spock.lang.Specification

class GetNavPageListSpec extends Specification {
    def "getPages returns an initial list of page numbers"() {
        given:
        def navPageList = new GetNavPageList()
        when:
        def result = navPageList.getNavPageList(currentPage, pagesOfResults, totalNumberofPages)
        then:
        result == pageList
        where:
        currentPage | pagesOfResults | totalNumberofPages | pageList
        1           | 10             | 27                 | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        2           | 10             | 27                 | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        7           | 10             | 27                 | [2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
        8           | 10             | 27                 | [3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
        23          | 10             | 27                 | [18, 19, 20, 21, 22, 23, 24, 25, 26, 27]
        1           | 5              | 27                 | [1, 2, 3, 4, 5]
        2           | 5              | 27                 | [1, 2, 3, 4, 5]
        4           | 5              | 27                 | [2, 3, 4, 5, 6]
        1           | 7              | 27                 | [1, 2, 3, 4, 5, 6, 7]
        4           | 7              | 27                 | [1, 2, 3, 4, 5, 6, 7]
        8           | 7              | 27                 | [5, 6, 7, 8, 9, 10, 11]
    }

    def "given a negative number for current page when getPages is called then an IllegalArgumentException is thrown"() {
        given:
        def navPageList = new GetNavPageList()
        when:
        def result = navPageList.getNavPageList(currentPage, pagesOfResults, totalNumberofPages)
        then:
        def exception = thrown IllegalArgumentException
        exception.message == exceptionMessage
        where:
        currentPage | pagesOfResults | totalNumberofPages | exceptionMessage
        -6           | 10              | 27                 | "Current Page must be greater than zero."
        37           | 10              | 27                 | "Current Page cannot be greater than Total Number of Pages."
    }
}
