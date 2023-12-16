package com.example.imagemanagement.controller;


import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import com.example.imagemanagement.app.AbstractApp;
import com.example.imagemanagement.app.AppFactory;
import com.example.imagemanagement.model.ImageInfo;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javaxt.io.Image;

/**
 * controller for image list.
 */
public class ImageListController extends AbstractController {
    @FXML
    private ListView lvImages;
    @FXML
    private ChoiceBox<String> cbFormat;

    private List<ImageInfo> imageInfoList;
    private Set<String> imagePathSet;
    private List<CheckBox> checkBoxList;

    /**
     * initialize controller.
     * @param location
     * The location used to resolve relative paths for the root object, or
     * <tt>null</tt> if the location is not known.
     *
     * @param resources
     * The resources used to localize the root object, or <tt>null</tt> if
     * the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imageInfoList = new ArrayList();
        imagePathSet = new HashSet();
        checkBoxList = new ArrayList();

        cbFormat.setItems(FXCollections.observableArrayList("JPEG", "PNG", "BMP"));
    }

    /**
     * Select images.
     */
    public void selectImages() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select images");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("ALL", "*.jpg", "*.jpeg", "*.bmp", "*.png"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("BMP", "*.bmp"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg", "*.jpeg")

        );
        List<File> fileList = fileChooser.showOpenMultipleDialog(AbstractApp.mainStage);
        if (fileList != null) {
            Iterator<File> fileIterator = fileList.iterator();
            while (fileIterator.hasNext()) {
                File file = fileIterator.next();
                if (imagePathSet.contains(file.getAbsolutePath())) {
                    fileIterator.remove();
                }
            }

            updateImageListView(fileList);
        }
    }

    /**
     * create image view.
     * @param image
     * @return
     */
    private ImageView createImageView(String image) {
        ImageView imageView = new ImageView("file:" + image);
        imageView.setFitHeight(50);
        imageView.setFitWidth(100);

        return imageView;
    }

    /**
     * update list.
     * @param fileList
     */
    public void updateImageListView(List<File> fileList) {
        List<Object> objects = new ArrayList<Object>();
        if (fileList != null) {
            for (int i = 0; i < fileList.size(); i++) {
                File file = fileList.get(i);
                if (imagePathSet.contains(file.getAbsolutePath())) {
                    continue;
                }

                ImageInfo imageInfo = new ImageInfo(file);
                imageInfo.setImageView(createImageView(file.getAbsolutePath()));
                imageInfoList.add(imageInfo);
            }
        }

        for (ImageInfo imageInfo : imageInfoList) {
            int col = 0;
            GridPane imageGrid = new GridPane();
            CheckBox checkBox = new CheckBox();
            checkBox.selectedProperty().addListener(new ImageSelectListener(imageInfo));
            checkBoxList.add(checkBox);
            imageGrid.add(checkBox, col++, 0);
            imageGrid.add(new Label("   "), col++, 0);
            imageGrid.add(imageInfo.getImageView(), col++, 0);
            imageGrid.add(new Label("   "), col++, 0);
            String name = formatStrLen(imageInfo.getName(), 64);
            imageGrid.add(new Label(name), col++, 0);
            imageGrid.add(new Label("   "), col++, 0);
            imageGrid.add(new Label(imageInfo.getType()), col++, 0);
            imageGrid.add(new Label("   "), col++, 0);
            Button detailBtn = new Button("Detail");
            imageGrid.add(detailBtn, col++, 0);
            detailBtn.setUserData(imageInfo);
            imageGrid.add(new Label(" "), col++, 0);
            Button removeBtn = new Button("Remove");
            imageGrid.add(removeBtn, col++, 0);

            detailBtn.setUserData(null);
            detailBtn.setOnMouseClicked(new DetailHandler(imageInfo));
            removeBtn.setOnMouseClicked(new RemoveHandler(imageInfo));

            objects.add(imageGrid);
        }

        lvImages.setItems(FXCollections.observableArrayList(objects));
    }

    /**
     * format str with fixed len.
     * @param str
     * @param len
     * @return
     */
    private String formatStrLen(String str, int len) {
        if (str == null) {
            str = "";
        }

        String[] tmp = str.split("\n");
        if (tmp[0].length() > len) {
            return tmp[0].substring(0, len);
        } else {
            StringBuilder sb = new StringBuilder(tmp[0]);
            for (int i = tmp[0].length(); i < len; i++) {
                sb.append(" ");
            }

            return sb.toString();
        }
    }

    /**
     * convert selected images.
     */
    public void convert() {
        String selectedFormat = cbFormat.getSelectionModel().getSelectedItem();
        if (selectedFormat == null) {
            alertError("Please select a format first");
        } else {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("Choose output directory");
            File outputDir = directoryChooser.showDialog(AbstractApp.mainStage);
            if (outputDir == null) {
                alertError("Please select a directory first");
                return;
            }

            Iterator<ImageInfo> iterator = imageInfoList.iterator();
            List<ImageInfo> convertedImages = new ArrayList<ImageInfo>();
            while (iterator.hasNext()) {
                ImageInfo imageInfo = iterator.next();
                if (imageInfo.isSelected()) {
                    Image image = new Image(imageInfo.getImageFile());
                    String currName = imageInfo.getName();
                    String newFileName = outputDir.getAbsolutePath() + "/" +
                            currName.substring(0, currName.lastIndexOf(".")) + "." + selectedFormat.toLowerCase();
                    image.saveAs(newFileName);
                    convertedImages.add(imageInfo);
                }
            }

            for (ImageInfo imageInfo : convertedImages) {
                removeImage(imageInfo);
            }

            if (convertedImages.isEmpty()) {
                alertError("No images selected");
            } else {
                alertInfo("Total " + convertedImages.size() + " images converted to path " +
                        outputDir.getAbsolutePath() + " with format " + selectedFormat);
            }
        }
    }

    /**
     * select all images.
     */
    public void selectAll() {
        for (CheckBox c: checkBoxList) {
            c.setSelected(true);
        }
    }

    /**
     * unselect all images.
     */
    public void unselectAll() {
        for (CheckBox c: checkBoxList) {
            c.setSelected(false);
        }
    }

    /**
     * remove image from list.
     * @param imageInfo
     */
    private void removeImage(ImageInfo imageInfo) {
        int idx = imageInfoList.indexOf(imageInfo);
        imagePathSet.remove(imageInfo.getImageFile().getAbsolutePath());
        imageInfoList.remove(idx);
        checkBoxList.remove(idx);

        updateImageListView(null);
    }

    /**
     * handler for remove image from list.
     */
    private class RemoveHandler implements EventHandler<MouseEvent> {
        private ImageInfo imageInfo;

        public RemoveHandler(ImageInfo imageInfo) {
            this.imageInfo = imageInfo;
        }

        @Override
        public void handle(MouseEvent event) {
            removeImage(imageInfo);
        }
    }

    /**
     * show image info.
     */
    private class DetailHandler implements EventHandler<MouseEvent> {
        private ImageInfo imageInfo;

        public DetailHandler(ImageInfo imageInfo) {
            this.imageInfo = imageInfo;
        }

        @Override
        public void handle(MouseEvent event) {
            AbstractApp.currentInfo = imageInfo;
            try {
                AppFactory.createApp().show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * select image.
     */
    private class ImageSelectListener implements ChangeListener<Boolean> {
        private ImageInfo imageInfo;

        public ImageSelectListener(ImageInfo imageInfo) {
            this.imageInfo = imageInfo;
        }

        @Override
        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
            imageInfo.setSelected(newValue);
        }
    }
}
