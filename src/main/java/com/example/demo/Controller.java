package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/goodController")
@AllArgsConstructor
@Slf4j
public class Controller {

    private GoodService goodService;

//    @ApiOperation(value = "create-good", notes = "create-good")
    @RequestMapping(value = "/create-good",method = RequestMethod.POST)
    public RestResponse<?> createGood(@RequestBody GoodDto good){
        try{
            return RestResponse.of(HttpStatus.OK,goodService.createGood(good), Map.of("0","Success"));
        }catch (Exception e){
            return RestResponse.of(HttpStatus.NOT_FOUND,e.getMessage(), Map.of("-1","Error"));
        }
    }

//    @ApiOperation(value = "find-all-good", notes = "find-all-good")
    @RequestMapping(value = "/find-all-good",method = RequestMethod.GET)
    public RestResponse<?> findAllGood(){
        try{
            return RestResponse.of(HttpStatus.OK,goodService.findAll(), Map.of("0","Success"));
        }catch (Exception e){
            return RestResponse.of(HttpStatus.NOT_FOUND,e.getMessage(), Map.of("-1","Error"));
        }
    }

//    @ApiOperation(value = "find-all-good", notes = "find-all-good")
    @RequestMapping(value = "/find-all-good-by-category",method = RequestMethod.POST)
    public RestResponse<?> findAllGoodByCategory(@RequestBody Good good){
        try{
            return RestResponse.of(HttpStatus.OK,goodService.findByCategory(good.getId()), Map.of("0","Success"));
        }catch (Exception e){
            return RestResponse.of(HttpStatus.NOT_FOUND,e.getMessage(), Map.of("-1","Error"));
        }
    }

//    @ApiOperation(value = "update-good", notes = "update-good")
    @RequestMapping(value = "/update-good",method = RequestMethod.PUT)
    public RestResponse<?> updateGood(@RequestBody GoodDto good){
        try{
            return RestResponse.of(HttpStatus.OK,goodService.updateGoodById(good), Map.of("0","Success"));
        }catch (Exception e){
            return RestResponse.of(HttpStatus.NOT_FOUND,e.getMessage(), Map.of("-1","Error"));
        }
    }

//    @ApiOperation(value = "delete-good", notes = "delete-good")
    @RequestMapping(value = "/delete-good",method = RequestMethod.DELETE)
    public RestResponse<?> deleteGood(@RequestBody Good good){
        try{
            return RestResponse.of(HttpStatus.OK,goodService.deleteById(good.getId()), Map.of("0","Success"));
        }catch (Exception e){
            return RestResponse.of(HttpStatus.NOT_FOUND,e.getMessage(), Map.of("-1","Error"));
        }
    }

//    @ApiOperation(value = "create-category", notes = "create-category")
    @RequestMapping(value = "/create-category",method = RequestMethod.POST)
    public RestResponse<?> deleteGood(@RequestBody Category category){
        try{
            return RestResponse.of(HttpStatus.OK,goodService.createCategory(category), Map.of("0","Success"));
        }catch (Exception e){
            return RestResponse.of(HttpStatus.NOT_FOUND,e.getMessage(), Map.of("-1","Error"));
        }
    }

//    @ApiOperation(value = "update-category", notes = "update-category")
    @RequestMapping(value = "/update-category",method = RequestMethod.PUT)
    public RestResponse<?> updateGood(@RequestBody Category category){
        try{
            return RestResponse.of(HttpStatus.OK,goodService.updateCategory(category), Map.of("0","Success"));
        }catch (Exception e){
            return RestResponse.of(HttpStatus.NOT_FOUND,e.getMessage(), Map.of("-1","Error"));
        }
    }

//    @ApiOperation(value = "delete-category", notes = "delete-category")
    @RequestMapping(value = "/delete-category",method = RequestMethod.DELETE)
    public RestResponse<?> deleteCategory(@RequestBody Category category){
        try{
            return RestResponse.of(HttpStatus.OK,goodService.deleteCategory(category.getId()), Map.of("0","Success"));
        }catch (Exception e){
            return RestResponse.of(HttpStatus.NOT_FOUND,e.getMessage(), Map.of("-1","Error"));
        }
    }


//    @ApiOperation(value = "find-all-category", notes = "find-all-category")
    @RequestMapping(value = "/find-all-category",method = RequestMethod.GET)
    public RestResponse<?> findAllCategory(){
        try{
            return RestResponse.of(HttpStatus.OK,goodService.findAllCategory(), Map.of("0","Success"));
        }catch (Exception e){
            return RestResponse.of(HttpStatus.NOT_FOUND,e.getMessage(), Map.of("-1","Error"));
        }
    }

}
