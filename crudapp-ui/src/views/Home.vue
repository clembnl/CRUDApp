<template>
  <Header @addEmployee="toggleAddForm" />
  <Employees v-show="showEmployees" 
    :employees="employees" 
    @delete-employee="deleteEmployee" 
    @upd-form="toggleUpdForm" />      
  <AddForm v-show="showAddForm" 
    @add-employee="addEmployee" />
  <!--
  <UpdateForm v-show="showUpdateForm" 
    :employee="employee" 
    @upd-employee="updateEmployee" />
  -->
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
      employee: null,
      showAddForm: false,
      showEmployees: true,
      showUpdateForm: false,
    }
  },
  methods: {
    toggleAddForm() {
      this.showAddForm = true
      this.showUpdateForm = false
      this.showEmployees = false
    },
    toggleUpdForm() {
      this.showAddForm = false
      this.showUpdateForm = true
      this.showEmployees = false
    },
    async fetchEmployees() {
      await axios
        .get('api/employees/')
        .then(() => {
          return res.json()
        })
        .catch((err) => console.log("err", err));
    },
    async fetchEmployee(id) {
      await axios
        .get(`api/employees/${id}`)
        .then(() => {
          return res.json()
        })
        .catch((err) => console.log("err", err));
    },
    async addEmployee(employee) {
      await axios
        .post('api/employees/add', employee)
        .then(() => {
          this.showAddForm = false
          this.showEmployees = true          
          this.employees = [...this.employees, employee]
          swal({
            text: "Employee added successfully",
            icon: "success",
          });
        })
        .catch((err) => console.log("err", err));
    },
    async updateEmployee(updemployee) {
      await axios
        .put('api/employees/add', updemployee)
        .then(() => {
          this.employees = this.employees.map((employee) => this.employee.id === updemployee.id)
          this.showUpdateForm = false
          this.showEmployees = true        
          swal({
            text: "Employee added successfully",
            icon: "success",
          });
        })
        .catch((err) => console.log("err", err));
    },    
    async deleteTask(id) {
      if (confirm('Are you sure')) {
        await axios
          .delete(`api/employees/delete/${id}`)
          .then(() => {
            res.status === 200
            ? this.employees = this.employees.filter((employee) => employee.id !== id)
            : alert('Error deleting task')
            swal({
              text: "Employee added successfully",
              icon: "success",
            });
          })
          .catch((err) => console.log("err", err));
      }
    },    
  },
  async created() {
    this.employees = await this.fetchEmployees()
  },
}
</script>