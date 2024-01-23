using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace can.Screens
{
    
    public partial class product : Form
    {
        //POSTutEntities db = new POSTutEntities();
        string imagepath ="";   //لتفادي مشكلةnull
        public product()
        {
            InitializeComponent();
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

        private void button1_Click(object sender, EventArgs e)
        {
            // if(txtName.Text==""|| txtBarcode.Text==""|| txtprice.Text == "")
            // {
            //  MessageBox.Show("الرجاء اكمال البيانات المطلوبة اولا")
            // }
            // else
            // {
            // can.Screens.product product = new can.Screens.product();
            // product.Name = txtName.Text;
            //  product.Code = txtBarcode.Text;
            //  product.Price = decimal.Parse(txtprice.Text);
            // product.Notes = txtNotes.Text;
           //  product.Quantity = int.parse( txtQty.Text);

            // db.Products.Add(p);
            // db.SaveChanges();
            //  MessageBox.Show(" تم حفظ المنتج")


            // if (imagepath != "")
            // {
            // string newpath = Environment.CurrentDirectory + "\\images\\Products\\" + p.id + "jpg";
            // File.Copy(imagepath, newpath);

            // p.Image = newpath;
            //  db.SaveChanges();
            //   }
            txtBarcode.Text = "";
            txtName.Text = "";
            txtQty.Text = "";
            txtNotes.Text = "";
            txtprice.Text = "";
            pictureBox1.ImageLocation = "";
            // }
        }
    }
}
