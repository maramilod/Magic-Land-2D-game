using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace can
{
    public partial class forrm : Form
    {
        //POSTutEntities db = new POSTutEntities();
        public forrm()
        {
            InitializeComponent();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            // var result = db.User.where(y=> y.num ==txtuser.Text && y.password == txtpassword.Text).Tolist()

          // if (result.count() > 0)
           // {




                this.Close();

                Thread th = new Thread(openform);
                th.SetApartmentState(ApartmentState.STA);
                th.Start();
            }
           // else
           // {
              //  MessageBox.Show("User name or password are invalid");
          //  }
       // }

        //اضافة دالة
        void openform()
        {
            Application.Run(new MainForm());
        }
    }
}
