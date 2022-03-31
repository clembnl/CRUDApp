<template>
    <div class="actions">
        <img @click="updateAction" src="../assets/edit_icon.svg" alt="edit icon" />
        <img @click="deleteAction" src="../assets/delete_icon.svg" alt="delete icon" />
    </div>
</template>

<script>
export default {
    name: "Actions",
    methods: {
        updateAction(e) {
            e.preventDefault()

            this.$emit("upd-employee")
        },
        deleteAction(e) {
            e.preventDefault()

            this.$emit("delete-employee")
        }
    }
}
</script>

<style scoped>
.actions {
    display: flex;
    padding: 10px;
    margin: 0;    
    width: 20%;
    justify-content: center;
}

img {
    width: 24px;
}
</style>