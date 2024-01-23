using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace can.Screens
{
    public partial class num : Form
    {
        string imagepath;


        public num()
        {
            InitializeComponent();
          // MessageBox.Show (Environment.CurrentDirectory+"\\a.jpg);
        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)

        {
            // Users u =new User
            // {
            //    UserName = txtuser.Text,
            //   Password=txtpassword.Text,
            //  Image =imagepath

            // };
            // db.Users,Add(u)
            // db.SaveChanges();
            MessageBox.Show("تم الحفظ");

            // if (imagepath != "")
            // {
            //  string newpath = Environment.CurrentDirectory + "\\images\\Users\\" + u.id + "jpg";
            //  File.Copy(imagepath, newpath);

            // u.Image = newpath;
            // db.SaveChanges();
            // }

            
        }

        

        private void pictureBox1_Click(object sender, EventArgs e)
        {
            OpenFileDialog dialog = new OpenFileDialog();
            if (dialog.ShowDialog() == DialogResult.OK)
            {
                imagepath = dialog.FileName;
                pictureBox1.ImageLocation = dialog.FileName;
            }
        }

        private void num_Load(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {

        }

        private void txtuser_TextChanged(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }
    }
}
