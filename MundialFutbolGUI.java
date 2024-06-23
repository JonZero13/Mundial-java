import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;


public class MundialFutbolGUI extends JFrame {
    public static void main(String[] args) {
    
        SwingUtilities.invokeLater(() -> {
            MundialFutbolGUI gui = new MundialFutbolGUI();
            gui.setVisible(true);
        });
    }
   
    private JComboBox<String> comboBoxEntidades;
    private JList<String> listDetalles;
    private JTextArea textAreaInfo;
    private JButton btnMostrarInfo;

   
    private Map<String, ArrayList<String>> entidades;
    private Map<String, String> entrenadores;
    private ArrayList<String> grupos;

    public MundialFutbolGUI() {
   
        entidades = new HashMap<>();
        entrenadores = new HashMap<>();
        grupos = new ArrayList<>();
        cargarDatosSimulados();

    
        setTitle("Gestión Mundial de Fútbol 2022");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

      
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        setContentPane(panelPrincipal);

    
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelSuperior.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel lblEntidad = new JLabel("Entidad:");
        panelSuperior.add(lblEntidad);

        comboBoxEntidades = new JComboBox<>();
        comboBoxEntidades.addItem("Equipo (32)");
        comboBoxEntidades.addItem("Grupo");
        comboBoxEntidades.addItem("Estadio");
        comboBoxEntidades.addItem("Mundial (2022)");
        comboBoxEntidades.addActionListener(e -> {
            mostrarDetallesEntidad((String) comboBoxEntidades.getSelectedItem());
        });
        panelSuperior.add(comboBoxEntidades);

        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);

        
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout());

        listDetalles = new JList<>();
        JScrollPane scrollDetalles = new JScrollPane(listDetalles);
        panelCentral.add(scrollDetalles, BorderLayout.CENTER);

        textAreaInfo = new JTextArea();
        textAreaInfo.setEditable(false);
        panelCentral.add(textAreaInfo, BorderLayout.SOUTH);

        panelPrincipal.add(panelCentral, BorderLayout.CENTER);

  
        JPanel panelLateral = new JPanel();
        panelLateral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelLateral.setLayout(new GridLayout(0, 1, 5, 5));

        btnMostrarInfo = new JButton("Mostrar Info");
        btnMostrarInfo.addActionListener(e -> {
            mostrarInfoSeleccionada();
        });
        panelLateral.add(btnMostrarInfo);

        panelPrincipal.add(panelLateral, BorderLayout.EAST);
    }

    private void cargarDatosSimulados() {
       
        String[] equipos = {
            "Qatar", "Ecuador", "Senegal", "Países Bajos",
            "Inglaterra", "Irán", "Estados Unidos", "Gales",
            "Argentina", "Arabia Saudita", "México", "Polonia",
            "Francia", "Australia", "Dinamarca", "Túnez",
            "España", "Costa Rica", "Alemania", "Japón",
            "Bélgica", "Canadá", "Marruecos", "Croacia",
            "Brasil", "Serbia", "Suiza", "Camerún",
            "Portugal", "Ghana", "Corea del Sur", "Uruguay"
        };

        String[] entrenadoresDetalles = {
            "Felix Sánchez es español, 46 años.",
            "Gustavo Alfaro es argentino, 60 años.",
            "Aliou Cissé es senegalés de 46 años.",
            "Louis Van Gaal es neerlandés de 71 años.",
            "Gareth Southgate es inglés de 52 años.",
            "Carlos Queiroz es portugués de 69 años.",
            "Gregg Berhalter es estadounidense de 49 años.",
            "Robert Page es galés de 48 años.",
            "Lionel Scaloni es argentino de 44 años.",
            "Hervé Renard es francés de 53 años.",
            "Gerardo Martino es argentino de 59 años.",
            "Czesław Michniewicz es polaco de 52 años.",
            "Didier Deschamps es francés de 54 años.",
            "Graham Arnold es australiano de 59 años.",
            "Kasper Hjulmand es danés de 50 años.",
            "Jalel Kadri es tunecino de 50 años.",
            "Luis Enrique es español de 52 años.",
            "Luis Fernando Suárez es colombiano de 62 años.",
            "Hansi Flick es alemán de 57 años.",
            "Hajime Moriyasu es japonés de 54 años.",
            "Roberto Martínez es español de 49 años.",
            "John Herdman es inglés de 47 años.",
            "Walid Regragui es francés-marroquí de 47 años.",
            "Zlatko Dalić es bosnio de 56 años.",
            "Tite es brasileño de 61 años.",
            "Dragan Stojković es serbio de 57 años.",
            "Murat Yakin es suizo de 48 años.",
            "Rigoberto Song es camerunés de 46 años.",
            "Fernando Santos es portugués de 68 años.",
            "Otto Addo es ghanés de 47 años.",
            "Paulo Bento es portugués de 53 años.",
            "Diego Alonso es uruguayo de 47 años."
        };

        for (int i = 0; i < equipos.length; i++) {
            entrenadores.put(equipos[i], entrenadoresDetalles[i]);
        }
ArrayList<String> partidos = new ArrayList<>();
        for (int i = 1; i <= 64; i++) {
            partidos.add("Partido " + i);}
        
        grupos.add("Grupo A: Qatar, Ecuador, Senegal, Países Bajos");
        grupos.add("Grupo B: Inglaterra, Irán, Estados Unidos, Gales");
        grupos.add("Grupo C: Argentina, Arabia Saudita, México, Polonia");
        grupos.add("Grupo D: Francia, Australia, Dinamarca, Túnez");
        grupos.add("Grupo E: España, Costa Rica, Alemania, Japón");
        grupos.add("Grupo F: Bélgica, Canadá, Marruecos, Croacia");
        grupos.add("Grupo G: Brasil, Serbia, Suiza, Camerún");
        grupos.add("Grupo H: Portugal, Ghana, Corea del Sur, Uruguay");
       
        ArrayList<String> estadios = new ArrayList<>();
        estadios.add("Estadio Ras Abu Aboud");
        estadios.add("Estadio Internacional Khalifa");
        estadios.add("Estadio Ahmad Bin Ali");
        estadios.add("Estadio Al Bayt");
        estadios.add("Estadio Al Janoub");
        estadios.add("Estadio Al Thumama");
        estadios.add("Estadio Ciudad de la Comunicación");
        estadios.add("Estadio Lusail");
       
        
        entidades.put("Equipo (32)", new ArrayList<>(entrenadores.keySet()));
        entidades.put("Grupo", grupos);
        entidades.put("Estadio", estadios);
        
    }

    private void mostrarDetallesEntidad(String entidad) {
        ArrayList<String> detalles = entidades.get(entidad);
        if (detalles != null) {
            listDetalles.setListData(detalles.toArray(new String[0]));
        } else {
            listDetalles.setListData(new String[]{});
        }
        textAreaInfo.setText(""); 
    }

    private void mostrarInfoSeleccionada() {
        String entidadSeleccionada = (String) comboBoxEntidades.getSelectedItem();
        String detalleSeleccionado = listDetalles.getSelectedValue();
        if (entidadSeleccionada != null && detalleSeleccionado != null) {

            String info = obtenerInformacion(entidadSeleccionada, detalleSeleccionado);
            textAreaInfo.setText(info);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una entidad y un detalle primero.");
        }
    }


private String obtenerInformacion(String entidad, String detalle) {
    StringBuilder info = new StringBuilder();
    if (entidad.equals("Equipo (32)")) {
       
        info.append("Información detallada de ").append(detalle).append(":\n");
        info.append("Entrenador: ").append(entrenadores.get(detalle)).append("\n");
        info.append("Plantilla de jugadores:\n");
        for (int j = 1; j <= 22; j++) {
            info.append(" - Jugador ").append(j).append("\n");
        }
    } else if (entidad.equals("Grupo")) {
   
        for (String grupo : grupos) {
            if (grupo.startsWith(detalle)) {
                info.append("Equipos en ").append(grupo).append(":\n");
                String[] equipos = grupo.substring(grupo.indexOf(":") + 2).split(", ");
                for (String equipo : equipos) {
                    info.append(" - ").append(equipo).append(": ");
                    info.append(entrenadores.get(equipo)).append("\n");
                }
            }
        }
    }
    return info.toString();
}
}