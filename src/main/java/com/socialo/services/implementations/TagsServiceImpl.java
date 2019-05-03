package com.socialo.services.implementations;

import com.socialo.dao.ITagsRepository;
import com.socialo.dto.TagDTO;
import com.socialo.models.Post;
import com.socialo.models.Tag;
import com.socialo.services.TagsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TagsServiceImpl implements TagsService {
    @Autowired
    private ITagsRepository repository;
    private ModelMapper modelMapper = new ModelMapper();


    public List<Tag> getAll(){
        List<TagDTO> dto = this.repository.findAll();
        Type listType = new TypeToken<List<Tag>>() {}.getType();
        return modelMapper.map(dto, listType);
    }

    public boolean isPresent(Tag tag){
        if(repository.findByName(tag.getName()) != null) {
            return true;
        }else{
            return false;
        }
    }

    @Transactional()
    public Tag create(Tag post){
        TagDTO tagDTO = modelMapper.map(post, TagDTO.class);
        return modelMapper.map(this.repository.save(tagDTO), Tag.class);
    }


    public List<TagDTO> getTags(String tags){
        String[] tagNames = tags.split(",");

        tagNames = Arrays.stream(tagNames).map(t -> t.toLowerCase().replaceAll("[^a-zA-Z0-9]", "")).toArray(String[]::new);

        List<TagDTO> existingTags = new ArrayList<>();

        Optional<TagDTO> tag;

        for(String tagName : tagNames){
            tag = repository.findOneByNameIgnoreCase(tagName);
            if(tag.isPresent()){
                existingTags.add(tag.get());
            }
        }

        return existingTags;

    }


}
