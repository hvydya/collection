package com.colbackend.collection.controllers;

import com.colbackend.collection.dto.CreateCollection;
import com.colbackend.collection.dto.CreateCollectionItem;
import com.colbackend.collection.exceptions.CreateCollectionItemException;
import com.colbackend.collection.models.Collection;
import com.colbackend.collection.models.CollectionItem;
import com.colbackend.collection.repositories.CollectionItemRepository;
import com.colbackend.collection.repositories.CollectionRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * created on: 03/03/21
 * created by: harsha
 */

@Api(value = "Collection Main", description = "CRUD Collections")
@RestController
@RequestMapping(path = "/api/c")
@CrossOrigin(origins = "*")
public class CollectionController {

    @Autowired
    CollectionRepository collectionRepository;

    @Autowired
    CollectionItemRepository collectionItemRepository;

    @ApiOperation(value = "Get all collections")
    @GetMapping(path = "")
    public ResponseEntity<List<Collection>> listCollections() {
        return ResponseEntity.ok(collectionRepository.findAll());
    }

    @ApiOperation(value = "Get a specific collection")
    @GetMapping(path = "/{colId}")
    public ResponseEntity<List<CollectionItemDto>> listCollection(@PathVariable("colId") Long colId) {
        if (!collectionRepository.existsById(colId)) {
            return ResponseEntity.notFound().build();
        }
        List<CollectionItem> collectionItems = collectionItemRepository.findByCollectionId(colId);
        List<CollectionItemDto> collectionItemDtos = new ArrayList<>();
        for (CollectionItem c: collectionItems) {
            collectionItemDtos.add(new CollectionItemDto(c));
        }
        return ResponseEntity.ok(collectionItemDtos);
    }

    @ApiOperation(value = "Create a collection")
    @PostMapping(path = "")
    public ResponseEntity<String> createCollection(@RequestBody CreateCollection createCollection) {
        String name = createCollection.getName();
        if (null == name) return ResponseEntity.badRequest().build();
        Optional<Collection> opt = collectionRepository.findByName(name);
        if (opt.isPresent()) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(collectionRepository.save(new Collection(name)).toString());
    }

    @ApiOperation(value = "Add item to a collection")
    @PostMapping(path = "/it")
    public ResponseEntity<String> createCollectionItem(@RequestBody CreateCollectionItem createCollectionItem) {
        if (null == createCollectionItem.getBack() || null == createCollectionItem.getColName() ||
                null == createCollectionItem.getFront()) {
            return ResponseEntity.badRequest().body("nulls provided");
        }
        Optional<Collection> opt = collectionRepository.findByName(createCollectionItem.getColName());
        return opt.map(collection -> ResponseEntity.ok().body(collectionItemRepository.save(new
                CollectionItem(createCollectionItem.getFront(),
                createCollectionItem.getBack(), collection)).toString())).
                orElseGet(() -> ResponseEntity.badRequest().body("Collection provided doesn't exist"));
    }

    @ApiOperation(value = "Get collection via name")
    @GetMapping(path = "/items")
    public ResponseEntity<List<CollectionItemDto>> listCollectionItemsViaName(@RequestParam("name") String name) {
        if (name == null) return ResponseEntity.badRequest().build();
        Optional<Collection> opt = collectionRepository.findByName(name);
        if (!opt.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        List<CollectionItem> collectionItems = collectionItemRepository.findByCollectionId(opt.get().getId());
        List<CollectionItemDto> collectionItemDtos = new ArrayList<>();
        for (CollectionItem c: collectionItems) {
            collectionItemDtos.add(new CollectionItemDto(c));
        }
        return ResponseEntity.ok(collectionItemDtos);
    }
}

class CollectionItemDto {
    private final String front;
    private final String back;

    public CollectionItemDto(CollectionItem c) {
        this.front = c.getFront();
        this.back = c.getBack();
    }

    public String getFront() {
        return front;
    }

    public String getBack() {
        return back;
    }
}
