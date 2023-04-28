package ru.malkov.naumentesttask.controllers;
import ru.malkov.naumentesttask.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.malkov.naumentesttask.exceptions.DaoCreationException;
import ru.malkov.naumentesttask.exceptions.NoSuchNameWasFoundException;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = DaoCreationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ExceptionDto handleException(DaoCreationException e) {
        return new ExceptionDto(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR), e.getMessage());
    }

    @ExceptionHandler(value = NoSuchNameWasFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ExceptionDto handleException(NoSuchNameWasFoundException e) {
        return new ExceptionDto(String.valueOf(HttpStatus.BAD_REQUEST), e.getMessage());
    }
}
