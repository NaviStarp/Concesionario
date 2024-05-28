package GUI;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Clases.Vehiculo;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.io.File;
import javax.swing.SwingConstants;

public class PanelCoche extends JPanel {

    private static final long serialVersionUID = 1L;

    public PanelCoche(Vehiculo vehiculo) {
        setBackground(new Color(255, 128, 128));
        setBorder(new LineBorder(Color.black));
        setLayout(null);

        JLabel ImagenLbl = new JLabel(new ImageIcon(PanelCoche.class.getResource(getImagePath(vehiculo.getMarca()))));
        ImagenLbl.setBounds(0, 12, 128, 128);
        add(ImagenLbl);

        JLabel MarcaModeloLbl = new JLabel(vehiculo.getMarca() + " " + vehiculo.getModelo());
        MarcaModeloLbl.setIcon(new ImageIcon(PanelCoche.class.getResource("/iconos/coche (2).png")));
        MarcaModeloLbl.setBounds(145, 40, 224, 19);
        MarcaModeloLbl.setFont(new Font("Cascadia Mono", Font.BOLD, 16));
        add(MarcaModeloLbl);

        JLabel PrecioLBL = new JLabel(vehiculo.getPrecio() + "€");
        PrecioLBL.setHorizontalAlignment(SwingConstants.CENTER);
        PrecioLBL.setBounds(843, 12, 88, 19);
        PrecioLBL.setFont(new Font("Cascadia Mono", Font.BOLD, 16));
        add(PrecioLBL);

        JLabel MatriculaLBL = new JLabel("Matrícula: " + vehiculo.getMatricula());
        MatriculaLBL.setIcon(new ImageIcon(PanelCoche.class.getResource("/iconos/Matricula.png")));
        MatriculaLBL.setBounds(138, 90, 251, 19);
        MatriculaLBL.setFont(new Font("Cascadia Mono", Font.BOLD, 16));
        add(MatriculaLBL);

        JLabel ColorLBL = new JLabel("Color: " + vehiculo.getColor());
        ColorLBL.setIcon(new ImageIcon(PanelCoche.class.getResource("/iconos/color.png")));
        ColorLBL.setBounds(421, 40, 233, 19);
        ColorLBL.setFont(new Font("Cascadia Mono", Font.BOLD, 16));
        add(ColorLBL);

        JLabel TipoLBL = new JLabel("Tipo: " + vehiculo.getTipo());
        TipoLBL.setIcon(new ImageIcon(PanelCoche.class.getResource("/iconos/Tipo.png")));
        TipoLBL.setBounds(421, 90, 197, 19);
        TipoLBL.setFont(new Font("Cascadia Mono", Font.BOLD, 16));
        add(TipoLBL);

        JLabel AñoLbl = new JLabel(vehiculo.getAño()+"");
        AñoLbl.setHorizontalAlignment(SwingConstants.CENTER);
        AñoLbl.setBounds(858, 121, 57, 19);
        AñoLbl.setFont(new Font("Cascadia Mono", Font.BOLD, 16));
        add(AñoLbl);
    }

    private String getImagePath(String marca) {
        String imagePath = "/iconos/marcas/" + marca.toLowerCase() + "-small-small.png";
        if (getClass().getResource(imagePath) == null) {
            // If the specific brand image does not exist, use the generic image
            imagePath = "/iconos/marcas/a-small-small.png";
        }
        return imagePath;
    }
}
