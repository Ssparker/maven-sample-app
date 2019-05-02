package edu.dmacc.codedsm.app;

public class FizzBuzzServiceImpl implements FizzBuzzService {

    private MapRepository repository;

    public FizzBuzzServiceImpl(MapRepository repository) {
        this.repository = repository;
    }

    public Result performFizzBuzzLogic(Submission submission) {
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

        Result result = createResult(submission, message);

        persistResultData(result);

        return result;
    }

    public Result createResult(Submission submission, String message) {
        Result result = new Result();
        result.setMessage(message);
        result.setSubmission(submission);
        return result;
    }

    private void persistResultData(Result result) {
        repository.save(result);
    }
}
