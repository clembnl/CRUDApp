<template>
    <div id="head">
        <p>Name</p>
        <p>Email</p>
        <p>Adress</p>
        <p>Arrival</p>
    </div>
    <div :key="employee.id" v-for="employee in employees">
        <Employee @upd-employee="$emit('upd-form', employee)"
        @delete-employee="$emit('delete-employee', task.id)" 
        :employee="employee" />
    </div>    
</template>

<script>
import Employee from './Employee'

export default {
    name: 'Employees',
    components: {
        Employee
    },
    props: {
        employees: Array
    },
    emits: ['update-employee', 'delete-employee']
    
}
</script>

<style scoped>
#head {
    display: flex;
    justify-content: space-around;
}
</style>