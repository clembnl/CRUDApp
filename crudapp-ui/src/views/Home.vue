<template>
  <Header @addEmployee="showAddForm" />
  <Employees :showEmployees="showEmployees" 
    :employees="employees" 
    @delete-employee="deleteEmployee" 
    @upd-form="showUpdForm" />
  <AddForm :showAddForm="showAddForm" 
    @add-employee="addEmployee" />
  <UpdateForm :showUpdateForm="showUpdateForm" 
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
      employees = [],
      employee = null,
    }
  },
  methods: {
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
          this.employees = this.employees.map((employee) => employee.id === updemployee.id)
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
  }
}
</script>