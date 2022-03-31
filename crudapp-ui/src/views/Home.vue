<template>
  <Header @addEmployee="toggleAddForm" 
    :text="showAddForm ? 'Close' : 'Add Employee'" 
    :color="showAddForm ? 'red' : 'green'" />
  <Employees v-show="showEmployees" 
    :employees="employees" 
    @delete-employee="deleteEmployee" 
    @upd-form="toggleUpdForm" />     
  <AddForm v-show="showAddForm" 
    @add-employee="addEmployee" />
  <UpdateForm v-if="showUpdateForm" 
    :employee="employee" 
    @upd-employee="updateEmployee" />
</template>

<script>
import Header from '../components/Header'
import Employees from '../components/Employees'
import AddForm from '../components/AddForm'
import UpdateForm from '../components/UpdateForm'
import axios from "axios"
import swal from "sweetalert"

export default {
  name: 'Home',
  components: {
    Header,
    Employees,
    AddForm,
    UpdateForm
  },
  data() {
    return {
      employees: [],
      employee: {
        id: '',
        name: '',
        email: '',
        adress: '',
        arrival: ''
      },
      showAddForm: false,
      showEmployees: true,
      showUpdateForm: false,
    }
  },
  methods: {
    toggleAddForm() {
      this.showAddForm = !this.showAddForm
      this.showUpdateForm = false
      this.showEmployees = !this.showEmployees
    },
    toggleUpdForm(id) {
      this.employee = this.employees.filter((employee) => employee.id === id)[0]
      this.showAddForm = false
      this.showUpdateForm = true
      this.showEmployees = false
    },
    async fetchEmployees() {
      await axios
        .get('api/employees/')
        .then(response => {
          this.employees = response.data
        })
        .catch((err) => console.log("err", err));
    },
    async addEmployee(employee) {
      await axios
        .post('api/employees/new', employee)
        .then(() => {
          this.showAddForm = false
          this.showEmployees = true          
          this.fetchEmployees()
          swal({
            text: "Employee added successfully",
            icon: "success",
          });
        })
        .catch((err) => {
          swal({
            text: "Verify employee information",
            icon: "error",
          });          
          console.log("err", err)
        });
    },
    async updateEmployee(updemployee) {
      console.log(updemployee)
      await axios
        .put(`api/employees/update/${updemployee.id}`, updemployee)
        .then(() => {
          //this.employees = this.employees.map((employee) => this.employee.id === updemployee.id)
          this.showUpdateForm = false
          this.showEmployees = true        
          swal({
            text: "Employee updated successfully",
            icon: "success",
          });
        })
        .catch((err) => {
          swal({
            text: "Verify employee information",
            icon: "error",
          });          
          console.log("err", err)
        });
    },    
    async deleteEmployee(id) {
      if (confirm('Are you sure')) {
        await axios
          .delete(`api/employees/delete/${id}`)
          .then(res => {
            res.status === 200
            ? this.employees = this.employees.filter((employee) => employee.id !== id)
            : alert('Error deleting task')
            swal({
              text: "Employee deleted successfully",
              icon: "success",
            });
          })
          .catch((err) => console.log("err", err));
      }
    },    
  },
  async created() {
    this.fetchEmployees()
  },
}
</script>