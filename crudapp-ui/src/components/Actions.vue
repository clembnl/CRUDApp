<template>
    <div class="actions">
        <img @click="updateAction" src="" alt="" />
        <img @click="deleteAction" src="" alt="" />
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