package finalproject;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
    private List<Video> videos;
    
    private String[] colunas = new String[]{
        "Title"};

    /** Creates a new instance of DevmediaTableModel */
    public TableModel(List<Video> videos) {
        this.videos = videos;
    }

    public TableModel(){
     this.videos = new ArrayList<Video>();
    }

    public int getRowCount() {
        return videos.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public String getColumnName(int columnIndex){
      return colunas[columnIndex];
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public void setValueAt(Video aValue, int rowIndex) {
        Video video = videos.get(rowIndex);

        video.setTitle(aValue.getTitle());
      
        fireTableCellUpdated(rowIndex, 0);
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
      Video video = videos.get(rowIndex);

     switch (columnIndex) {
         case 0:
             video.setTitle(aValue.toString());

         default:
             System.err.println("Índice da coluna inválido");
     }
        fireTableCellUpdated(rowIndex, columnIndex);
     }


    public Object getValueAt(int rowIndex, int columnIndex) {
        Video selectedVideo = videos.get(rowIndex);
        String valueObject = null;
       
        valueObject = selectedVideo.getTitle();

        return valueObject;
       
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }


    public Video getVideo(int lineIndex) {
        return videos.get(lineIndex);
    }

    public void addVideo(Video v) {
        videos.add(v);


        int lastIndex = getRowCount() - 1;

        fireTableRowsInserted(lastIndex, lastIndex);
    }


    public void addListVideo(List<Video> newVideos) {

        int lastTam = getRowCount();
        videos.addAll(newVideos);
        fireTableRowsInserted(lastTam, getRowCount() - 1);
    }

    public void clear() {
        videos.clear();
        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return videos.isEmpty();
    }
}
