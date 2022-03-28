<template>
  <Header />
  <Employees :showEmployees="showEmployees" />
  <AddForm :showAddForm="showAddForm" />
  <UpdateForm :showUpdateForm="showUpdateForm" />
</template>

<script>
import Header from '../components/Header'
import Employees from '../components/Employees'
import AddForm from '../components/AddForm'
import UpdateForm from '../components/UpdateForm'

export default {
  name: 'Home',
  components: {
    Header,
    Employees,
    AddForm,
    UpdateForm
  }
}
</script>
