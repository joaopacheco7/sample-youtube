package finalproject;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModel2 extends AbstractTableModel {
    private List<Visualization> vis;
    
    private String[] colunas = new String[]{
        "Spectator", "Video"};

    /** Creates a new instance of DevmediaTableModel2 */
    public TableModel2(List<Visualization> vis) {
        this.vis = vis;
    }

    public TableModel2(){
     this.vis = new ArrayList<Visualization>();
    }

    public int getRowCount() {
        return vis.size();
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

    public void setValueAt(Visualization aValue, int rowIndex) {
        Visualization visu = vis.get(rowIndex);

        visu.setSpectator(aValue.getSpectator());
        visu.setMovie(aValue.getMovie());
      
        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
    }

    public void setValueAt(Visualization aValue, int rowIndex, int columnIndex) {
      Visualization visu = vis.get(rowIndex);

     switch (columnIndex) {
         case 0:
             visu.setSpectator(aValue.getSpectator());
         case 1:
             visu.setMovie(aValue.getMovie());
         default:
             System.err.println("Índice da coluna inválido");
     }
        fireTableCellUpdated(rowIndex, columnIndex);
     }


    public Object getValueAt(int rowIndex, int columnIndex) {
        Visualization selectedVisualization = vis.get(rowIndex);
        
        String valueObject = null;
        switch(columnIndex){
           case 0: valueObject = selectedVisualization.getSpectator().getLogin(); break;
           case 1: valueObject = selectedVisualization.getMovie().getTitle(); break;
           default: System.err.println("Índice inválido");
        }

        return valueObject;
       
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }


    public Visualization getUsuario(int lineIndex) {
        return vis.get(lineIndex);
    }

    public void addVisualization(Visualization u) {
        vis.add(u);


        int lastIndex = getRowCount() - 1;

        fireTableRowsInserted(lastIndex, lastIndex);
    }

    public void addListVisualization(List<Visualization> newVisualizations) {

        int lastTam = getRowCount();
        vis.addAll(newVisualizations);
        fireTableRowsInserted(lastTam, getRowCount() - 1);
    }

    public void clear() {
        vis.clear();
        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return vis.isEmpty();
    }
}
