package spring.springboot.FileManagement.File.application;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import spring.springboot.FileManagement.File.infraestructure.dto.input.FileInputDTO;
import spring.springboot.FileManagement.File.infraestructure.dto.output.FileOutputDTO;
import spring.springboot.FileManagement.File.repository.FileRepository;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

@Service
public class FileService implements FileInterface{

    @Autowired
    FileRepository fileRepository;

    @Override
    public FileOutputDTO getFileByID(int id) {
        return null;
    }

    @Override
    public FileOutputDTO getFileByName(String name) {
        return null;
    }

    @Override
    public FileOutputDTO postFile(FileInputDTO fileInputDTO) throws IOException {
        String fileName = StringUtils.cleanPath(fileInputDTO.getFile().getOriginalFilename());
        byte[] data = fileInputDTO.getFile().getBytes();
        String fileType = fileInputDTO.getFile().getContentType();

        FileEntity fileEntity = new FileEntity(data, fileName, fileType);
        fileRepository.save(fileEntity);

        return new FileOutputDTO(fileEntity);
    }
}
