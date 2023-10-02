<script setup lang="ts">
import ShoppingItemForm from '@/components/ShoppingItemForm.vue'
import { ElMessage } from 'element-plus'

const createShoppingItem = (shoppingItem: any) => {
  console.log('ShoppingItem', shoppingItem)
  ElMessage({
    message: 'Shopping item created',
    type: 'success'
  })
}
</script>

<template>
  <h1>ShoppingList</h1>
  <shopping-item-form @send-message="createShoppingItem"></shopping-item-form>
</template>

<style scoped></style>
