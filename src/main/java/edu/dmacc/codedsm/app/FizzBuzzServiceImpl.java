package edu.dmacc.codedsm.app;

public class FizzBuzzServiceImpl implements FizzBuzzService {

    private MapRepository repository;

    //1st unit
    public FizzBuzzServiceImpl(MapRepository repository) {
        this.repository = repository;
    }

    //2nd unit
    public FizzyResult performFizzBuzzLogic(Submission submission) {
        String message = "";
        if (submission.getInputNumber() % 3 == 0 && submission.getInputNumber() % 5 == 0) {
            message = "FizzBuzz!";
        } else if (submission.getInputNumber() % 3 == 0) {
            message = "Fizz";
        } else if (submission.getInputNumber() % 5 == 0) {
            message = "Buzz";
        } else {
            message = "Input was not fizzy";
        }

        FizzyResult fizzyResult = createResult(submission, message);

        persistResultData(fizzyResult);

        return fizzyResult;
    }

    //3rd unit
    public FizzyResult createResult(Submission submission, String message) {
        FizzyResult fizzyResult = new FizzyResult();
        fizzyResult.setMessage(message);
        fizzyResult.setSubmission(submission);
        return fizzyResult;
    }

    //2nd unit
    private void persistResultData(FizzyResult fizzyResult) {
        repository.save(fizzyResult);
    }
}
