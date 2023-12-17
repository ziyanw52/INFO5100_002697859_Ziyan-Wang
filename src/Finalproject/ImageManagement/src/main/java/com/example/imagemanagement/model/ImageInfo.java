package com.example.imagemanagement.model;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.file.FileSystemDirectory;
import com.drew.metadata.file.FileTypeDirectory;
import com.drew.metadata.icc.IccDirectory;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.Date;
import java.util.Objects;

/**
 * class to represent image info.
 */
public class ImageInfo {
    private String name;
    private String width;
    private String height;
    private String type;
    private String camera;
    private String size;
    private String modifyDate;
    private String colorSpace;
    private boolean selected;

    private File imageFile;
    private ImageView imageView;

    public ImageInfo(File imageFile) {
        this.imageFile = imageFile;
        name = imageFile.getName();

        try {
            Metadata metadata = ImageMetadataReader.readMetadata(imageFile);
            Directory exifSubDir = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
            height = exifSubDir.getDescription(ExifSubIFDDirectory.TAG_EXIF_IMAGE_HEIGHT);
            width = exifSubDir.getDescription(ExifSubIFDDirectory.TAG_EXIF_IMAGE_WIDTH);
            colorSpace = exifSubDir.getDescription(ExifSubIFDDirectory.TAG_COLOR_SPACE);
            type = metadata.getFirstDirectoryOfType(FileTypeDirectory.class).getDescription(FileTypeDirectory.TAG_DETECTED_FILE_TYPE_NAME);
            size = metadata.getFirstDirectoryOfType(FileSystemDirectory.class).getString(FileSystemDirectory.TAG_FILE_SIZE);
            modifyDate = metadata.getFirstDirectoryOfType(FileSystemDirectory.class).getString(FileSystemDirectory.TAG_FILE_MODIFIED_DATE);
            camera = metadata.getFirstDirectoryOfType(IccDirectory.class).getString(IccDirectory.TAG_DEVICE_MAKE);
        } catch (Exception e) {
            System.out.println("Read meta failed: " + e.getMessage());
            type = name.substring(name.lastIndexOf(".") + 1).toUpperCase();
            size = imageFile.length() + " bytes";
            modifyDate = new Date(imageFile.lastModified()).toString();
        }

        height = height == null ? "Unknown": height;
        width = width == null ? "Unknown" : width;
        colorSpace = colorSpace == null ? "Unknown" : colorSpace;
        camera = camera == null ? "Unknown" : camera;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public File getImageFile() {
        return imageFile;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getName() {
        return name;
    }

    public String getWidth() {
        return width;
    }

    public String getHeight() {
        return height;
    }

    public String getType() {
        return type;
    }

    public String getCamera() {
        return camera;
    }

    public String getSize() {
        return size;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public String getColorSpace() {
        return colorSpace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ImageInfo imageInfo = (ImageInfo) o;
        return imageFile.equals(imageInfo.imageFile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageFile);
    }

    @Override
    public String toString() {
         return "Name = " + name +
                 "\nWidth = " + width +
                 "\nHeight = " + height +
                 "\nColorSpace = " + colorSpace +
                 "\nType = " + type +
                 "\nCamera = " + camera +
                 "\nSize = " + size +
                 "\nModifyDate = " + modifyDate;
    }
}
