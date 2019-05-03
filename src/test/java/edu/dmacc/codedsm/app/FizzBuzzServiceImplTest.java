package edu.dmacc.codedsm.app;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzServiceImplTest {

    private MapRepository stubMapRepository;
    private FizzBuzzServiceImpl classUnderTest;

    @Before
    public void setUp() throws Exception {
        stubMapRepository = new MapRepository() {
            @Override
            public void save(FizzyResult fizzyResult) {

            }
        };

        classUnderTest = new FizzBuzzServiceImpl(stubMapRepository);
    }

    @Test
    public void shouldNotBeFizzy() {
        Submission expectedSubmission = new Submission();
        expectedSubmission.setInputNumber(17);

        FizzyResult fizzyResult = classUnderTest.performFizzBuzzLogic(expectedSubmission);

        assertEquals("Input was not fizzy", fizzyResult.getMessage());
    }

    @Test
    public void shouldBeFizzbuzz() {
        Submission expectedSubmission = new Submission();
        expectedSubmission.setInputNumber(15);

        FizzyResult fizzyResult = classUnderTest.performFizzBuzzLogic(expectedSubmission);

        assertEquals("FizzBuzz!", fizzyResult.getMessage());
    }
}