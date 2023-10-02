<script setup lang="ts">
import { ref } from 'vue'
import { ElForm, ElFormItem, ElInput, ElButton } from 'element-plus'

const formInput = ref({ item: '', purchased: false })

const emit = defineEmits(['send-message'])

const onSubmit = () => {
  emit('send-message', formInput.value)
}
</script>

<template>
  <el-form @submit.prevent :inline="true" :model="formInput" class="shopping-item-form-input">
    <el-form-item label="Item" prop="item">
      <el-input v-model="formInput.item" placeholder="Enter Item"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit()">Add</el-button>
    </el-form-item>
  </el-form>
</template>

<style scoped></style>
