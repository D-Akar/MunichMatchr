<template>
    <div>
        <h2>{{ title }}</h2>
        <div>
            <p>Tags</p>
            <p>Short blurb</p>
            <p>Contact Info</p>
            <button>Query button</button>
        </div>
    </div>
</template>

<script setup>
    defineProps(['title', 'details'])
</script>