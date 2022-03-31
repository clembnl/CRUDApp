<template>
    <header>
        <h1>Manage Employees</h1>
        <button @click="onClick" :style="{ background: color }">{{ text }}</button>
    </header>
</template>

<script>
export default {
    name: 'Header',
    props: {
        text: String,
        color: String,
    },
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
    background-color: rgb(77, 84, 180);
    display: flex;
    justify-content: space-between;
    font-family: "Rubik", sans-serif;
}

h1 {
    color: white;
    padding-left: 15px;
}

button {
    color: white;
    border: none;
    padding: 6px;
    margin: 15px 10px 15px 10px;
    border-radius: 1px;
    width: 8%;
}
</style>