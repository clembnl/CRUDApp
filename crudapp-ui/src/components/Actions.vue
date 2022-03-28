<template>
    <div class="actions">
        <img @click="updateAction" />
        <img @click="deleteAction" />
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
}
</style>