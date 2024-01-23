using can.Screens;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace can
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }

        private void productsToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void closeToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void addNewUserToolStripMenuItem_Click(object sender, EventArgs e)
        {
            num f = new num();
            f.Show();


        }

        private void addProductToolStripMenuItem_Click(object sender, EventArgs e)
        {
            product m = new product();
            m.Show();
        }
    }
}
