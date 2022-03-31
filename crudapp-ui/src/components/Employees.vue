<template>
    <div id="items">
        <div id="head">
            <p>Name</p>
            <p>Email</p>
            <p>Adress</p>
            <p>Arrival</p>
            <p>Actions</p>
        </div>
        <div id="list" :key="employee.id" v-for="employee in employees">
            <Employee @upd-employee="$emit('upd-form', employee.id)"
            @delete-employee="$emit('delete-employee', employee.id)" 
            :employee="employee" />
        </div>    
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
}
</script>

<style scoped>
#head {
    display: flex;
    justify-content: space-around;
    border-bottom: solid 1px rgb(210,210,210);
}

#head p {
    margin: 0;
    padding: 10px;
    width: 20%;
    text-align: center;
    font-weight: bold;
}

#items {
    margin: 1%;
    border-top: solid 1px rgb(210,210,210);
    font-family: 'Poppins', sans-serif;
}

#items :hover {
    background-color: rgb(210,210,210);
}
</style>