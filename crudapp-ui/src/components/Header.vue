<template>
    <header>
        <h1>Manage Employees</h1>
        <button @click="onClick" >Add New Employee</button>
    </header>
</template>

<script>
export default {
    name: 'Header',
    methods: {
        onClick(e) {
            e.preventDefault()

            this.$emit('addEmployee')
        }
    }
}
</script>

<style>
header {
    background-color: darkslateblue;
    display: flex;
    justify-content: space-between;
}

h1 {
    color: white;
}

button {
    background-color: rgb(34, 204, 28);
    color: white;
    border: none;
    padding: 3px;
}
</style>