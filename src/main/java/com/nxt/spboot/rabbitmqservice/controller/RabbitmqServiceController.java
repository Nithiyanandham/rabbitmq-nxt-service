package com.nxt.spboot.rabbitmqservice.controller;

import com.nxt.spboot.rabbitmqservice.common.RabbitmqServiceContants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by nithi on 2019-02-21.
 *
 */
@Slf4j
@RestController
@RequestMapping(RabbitmqServiceContants.CONTROLLER_URI)
@Api(tags= RabbitmqServiceContants.CONTROLLER_TAG, value = RabbitmqServiceContants.CONTROLLER_TITLE)
public class RabbitmqServiceController {


    @ApiOperation(value = "Publish messgae to RMQ", httpMethod = "POST")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Message published successfully", response = String.class)})
    @PostMapping(value = RabbitmqServiceContants.PUBLISH)
    public ResponseEntity<String> publish(@RequestParam("message") String message)
    {
        long startTime = System.currentTimeMillis();
        log.info("Started : Publishing message ......");

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        log.info("Message submitted time : {} ms", executionTime);

        log.info("Completed : Message successfully published......");
        return new ResponseEntity<>("Message successfully publishedcls", HttpStatus.OK);
    }

}
