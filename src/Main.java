import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashSet;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import repository.FakeDataRepository;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import java.awt.Cursor;

public class Main {

	private JFrame frmCarsCombobox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmCarsCombobox.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try {
			// Set cross-platform Java L&F (also called "Metal")
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}

		frmCarsCombobox = new JFrame();
		frmCarsCombobox.setTitle("Cars ComboBox");
		frmCarsCombobox.setBounds(100, 100, 265, 175);
		frmCarsCombobox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCarsCombobox.setResizable(false);

		JLayeredPane layeredPane = new JLayeredPane();
		frmCarsCombobox.getContentPane().add(layeredPane, BorderLayout.CENTER);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(12, 12, 231, 24);
		layeredPane.add(comboBox);

		comboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));

		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(12, 48, 231, 24);
		layeredPane.add(comboBox_1);

		comboBox_1.setCursor(new Cursor(Cursor.HAND_CURSOR));

		JComboBox<String> comboBox_1_1 = new JComboBox<String>();
		comboBox_1_1.setBounds(12, 87, 231, 24);
		layeredPane.add(comboBox_1_1);

		comboBox_1_1.setCursor(new Cursor(Cursor.HAND_CURSOR));

		Thread t1 = new Thread(() -> {

			FakeDataRepository fakeDataRepository = new FakeDataRepository();
			List<String> sortedCars = fakeDataRepository.fakeData();

			for (String car : sortedCars) {
				comboBox.addItem(car);
			}
		});

		t1.start();

		Thread t2 = new Thread(() -> {

			FakeDataRepository fakeDataRepository = new FakeDataRepository();
			List<String> sortedCarsReversed = fakeDataRepository.fakeDataReverse();

			for (String car : sortedCarsReversed) {
				comboBox_1.addItem(car);
			}
		});

		t2.start();

		Thread t3 = new Thread(() -> {

			FakeDataRepository fakeDataRepository = new FakeDataRepository();
			HashSet<String> unorderedCars = fakeDataRepository.fakeDataUnordered();

			for (String car : unorderedCars) {
				comboBox_1_1.addItem(car);
			}
		});

		t3.start();

	}

	public Main() {
		initialize();

		Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/carro.png"));
		frmCarsCombobox.setIconImage(img);
		
		frmCarsCombobox.setLocationRelativeTo(null);

	}

}
